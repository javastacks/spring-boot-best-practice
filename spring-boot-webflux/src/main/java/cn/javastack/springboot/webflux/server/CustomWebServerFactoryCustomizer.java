package cn.javastack.springboot.webflux.server;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.server.reactive.ConfigurableReactiveWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义Web服务器工厂定制器
 * 微信公众号：Java技术栈
 */
@Component
public class CustomWebServerFactoryCustomizer
		implements WebServerFactoryCustomizer<ConfigurableReactiveWebServerFactory> {

	@Override
	public void customize(ConfigurableReactiveWebServerFactory server) {
		server.setPort(8080);
	}

}