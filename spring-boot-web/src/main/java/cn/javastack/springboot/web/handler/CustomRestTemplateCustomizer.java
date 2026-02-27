package cn.javastack.springboot.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.impl.routing.DefaultProxyRoutePlanner;
import org.apache.hc.client5.http.routing.HttpRoutePlanner;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.restclient.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@Component
public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {

    private static final Timeout CONNECT_TIMEOUT = Timeout.ofSeconds(5);

    private static final Duration READ_TIMEOUT = Duration.ofSeconds(5);

    private static final Duration CONNECTION_REQUEST_TIMEOUT = Duration.ofSeconds(5);

    @Override
    public void customize(RestTemplate restTemplate) {
        HttpRoutePlanner routePlanner = new CustomRoutePlanner(new HttpHost("proxy.javastack.cn"));
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .build();
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
                        .setDefaultConnectionConfig(connectionConfig)
                        .build())
                .setRoutePlanner(routePlanner).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        requestFactory.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT);
        requestFactory.setReadTimeout(READ_TIMEOUT);
        restTemplate.setRequestFactory(requestFactory);
    }

    static class CustomRoutePlanner extends DefaultProxyRoutePlanner {

        CustomRoutePlanner(HttpHost proxy) {
            super(proxy);
        }

        @Override
        protected HttpHost determineProxy(HttpHost target, HttpContext context) throws HttpException {
            log.info("hostName is {}", target.getHostName());
            if ("localhost".equals(target.getHostName())) {
                return null;
            }
            return super.determineProxy(target, context);
        }

    }

}
