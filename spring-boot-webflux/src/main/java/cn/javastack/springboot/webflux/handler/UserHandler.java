package cn.javastack.springboot.webflux.handler;

import cn.javastack.springboot.webflux.bean.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户 Handler
 * 微信公众号：Java技术栈
 */
@Component
public class UserHandler {

    /**
     * 获取用户信息
     */
    public Mono<ServerResponse> getUserInfo(ServerRequest request) {
        String userId = request.pathVariable("userId");
        User user = new User("Routing - Java技术栈", 18);
        user.setId(Long.valueOf(userId));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(user);
    }

    /**
     * 获取用户列表
     */
    public Mono<ServerResponse> users(ServerRequest request) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("Routing - Java技术栈", 10 + i);
            user.setId((long) (i + 1));
            users.add(user);
        }
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(users);
    }

    /**
     * 获取用户列表（流式输出）
     */
    public Mono<ServerResponse> usersStream(ServerRequest request) {
        Flux<User> flux = Flux.range(1, 5)
                .map(i -> {
                    User user = new User("Routing - Java技术栈", 10 + i);
                    user.setId((long) i);
                    return user;
                })
                .delayElements(Duration.ofSeconds(1));
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(flux, User.class);
    }

}