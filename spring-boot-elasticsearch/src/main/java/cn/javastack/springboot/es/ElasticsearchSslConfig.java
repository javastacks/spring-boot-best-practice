package cn.javastack.springboot.es;

import co.elastic.clients.transport.rest5_client.low_level.Rest5ClientBuilder;
import org.springframework.boot.elasticsearch.autoconfigure.Rest5ClientBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * Elasticsearch SSL 配置类
 */
@Configuration
public class ElasticsearchSslConfig {

    /**
     * 注册 Elasticsearch Rest5 客户端构建器定制器，统一注入 SSL 上下文。
     * @return Rest5 客户端构建器定制器
     */
    @Bean
    public Rest5ClientBuilderCustomizer insecureSslRest5ClientBuilderCustomizer() {
        return new Rest5ClientBuilderCustomizer() {
            @Override
            public void customize(Rest5ClientBuilder builder) {
                builder.setSSLContext(trustAllSslContext());
            }
        };
    }

    /**
     * 构建 SSL 上下文，用于支持当前 Elasticsearch TLS 连接。
     * @return SSL 上下文
     */
    private SSLContext trustAllSslContext() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new TrustAllX509TrustManager()}, new SecureRandom());
            return sslContext;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("创建 Elasticsearch 客户端 SSL 上下文失败", e);
        }
    }

    /**
     * 自定义证书信任管理器。
     */
    private static class TrustAllX509TrustManager implements X509TrustManager {

        /**
         * 客户端证书校验。
         */
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        /**
         * 服务端证书校验。
         */
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        /**
         * 返回受信任的颁发者列表。
         */
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

}
