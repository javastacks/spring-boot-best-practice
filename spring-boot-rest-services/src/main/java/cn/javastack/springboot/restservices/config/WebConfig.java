package cn.javastack.springboot.restservices.config;

import cn.javastack.springboot.restservices.handler.CustomRestTemplateCustomizer;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CustomRestTemplateCustomizer customRestTemplateCustomizer;

    @Bean
    public RestTemplate defaultRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("test", "test"));
        customRestTemplateCustomizer.customize(restTemplate);
        return restTemplate;
    }

    @Bean
    public RestClient defaultRestClient(RestClient.Builder restClientBuilder) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(Duration.ofSeconds(3));
        requestFactory.setReadTimeout(Duration.ofSeconds(3));
        return restClientBuilder
                .baseUrl("http://localhost:8080")
                .defaultHeader("Authorization", "Bearer test")
                .requestFactory(requestFactory)
                .build();
    }

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(client ->
                        client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3)
                                .doOnConnected(conn -> {
                                    conn.addHandlerLast(new ReadTimeoutHandler(3000));
                                    conn.addHandlerLast(new WriteTimeoutHandler(3000));
                                })
                );
        ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        return webClientBuilder.clientConnector(connector).build();
    }

    /**
     * API 版本控制（在配置文件中配置即可，不需要重复配置）
     * @param configurer
     */
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.setDefaultVersion("1.0");
        configurer.useRequestHeader("X-Version");
        configurer.useQueryParam("version");
        configurer.usePathSegment(2);
        configurer.addSupportedVersions("1.3", "1.4");
    }

}
