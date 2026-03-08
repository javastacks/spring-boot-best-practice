package cn.javastack.springboot.webflux.config;

import cn.javastack.springboot.webflux.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 函数式路由配置
 * 微信公众号：Java技术栈
 */
@Configuration(proxyBeanMethods = false)
public class RoutingConfiguration {

    /**
     * 用户接口函数式路由
     * @param handler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserHandler handler) {
        return route()
                .GET("/routingUsers", handler::users)
                .GET("/routingUsers/stream", handler::usersStream)
                .GET("/routingUsers/{userId}", handler::getUserInfo)
                .build();
    }

}