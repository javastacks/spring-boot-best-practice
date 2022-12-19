package cn.javastack.springboot.web.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

import java.time.Duration;

/**
 * 自定义 Web Server
 * 微信公众号：Java技术栈
 */
//@Component
public class CustomTomcatWebServerFactoryCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory server) {
        server.addConnectorCustomizers((connector) -> {
            connector.setPort(8088);
            connector.setAsyncTimeout(Duration.ofSeconds(20).toMillis());
        });
    }

}