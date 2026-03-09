package cn.javastack.springboot.webflux.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 测试过滤器
 * 微信公众号：Java技术栈
 */
@Component
public class TestWebFilter implements WebFilter {

    public static final String FROM_FILTER = "FROM-FILTER";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest()
                .mutate()
                .header(FROM_FILTER, "TestWebFilter")
                .build();

        ServerWebExchange newExchange = exchange.mutate()
                .request(request)
                .build();

        newExchange.getResponse().getHeaders().set(FROM_FILTER, request.getHeaders().getFirst(FROM_FILTER));
        return chain.filter(newExchange);
    }

}
