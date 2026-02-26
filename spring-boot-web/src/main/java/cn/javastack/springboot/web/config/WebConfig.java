package cn.javastack.springboot.web.config;

import cn.javastack.springboot.web.handler.CustomConverter;
import cn.javastack.springboot.web.handler.CustomRestTemplateCustomizer;
import cn.javastack.springboot.web.handler.StringWithoutSpaceDeserializer;
import cn.javastack.springboot.web.servlet.InitServlet;
import cn.javastack.springboot.web.servlet.RegisterServlet;
import jakarta.servlet.ServletRegistration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.http.converter.json.JacksonJsonHttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

import java.time.Duration;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CustomRestTemplateCustomizer customRestTemplateCustomizer;

    /**
     * Locale 默认设置为英文
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * 切换语言拦截器，通过 url?lang=zh_CN 形式进行切换
     * @return
     */
    private LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CustomConverter());
    }

    @Bean
    public JacksonJsonHttpMessageConverter jacksonJsonHttpMessageConverter() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new StringWithoutSpaceDeserializer(String.class));

        JsonMapper mapper = JsonMapper.builder()
                .addModule(module)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
        return new JacksonJsonHttpMessageConverter(mapper);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**")
                .allowedMethods("GET", "POST")
                .allowedOrigins("https://javastack.cn")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(true).maxAge(3600);
    }

    @Bean
    public ServletRegistrationBean registerServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new RegisterServlet(), "/registerServlet");
        servletRegistrationBean.addInitParameter("name", "registerServlet");
        servletRegistrationBean.addInitParameter("sex", "man");
        servletRegistrationBean.setIgnoreRegistrationFailure(true);
        return servletRegistrationBean;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return (servletContext) -> {
            ServletRegistration initServlet = servletContext.addServlet("initServlet", InitServlet.class);
            initServlet.addMapping("/initServlet");
            initServlet.setInitParameter("name", "initServlet");
            initServlet.setInitParameter("sex", "man");
        };
    }

    @Bean
    public RestTemplate defaultRestTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(Duration.ofSeconds(5));
        requestFactory.setReadTimeout(Duration.ofSeconds(5));

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("test", "test"));
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

}
