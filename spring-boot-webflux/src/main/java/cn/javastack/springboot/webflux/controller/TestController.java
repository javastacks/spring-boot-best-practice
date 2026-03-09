package cn.javastack.springboot.webflux.controller;

import cn.javastack.springboot.webflux.filter.TestWebFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

/**
 * 测试控制器
 * 微信公众号：Java技术栈
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    /**
     * 测试模块引擎
     * @param content
     * @param model
     * @return
     */
    @GetMapping("/test/{content}")
    public String test(@PathVariable String content, Model model) {
        model.addAttribute("content", content);
        return "test";
    }

    /**
     * 测试请求和响应
     * @param request
     * @param response
     * @param webSession
     * @return
     */
    @GetMapping("/test/request")
    @ResponseBody
    public Mono<String> test(ServerHttpRequest request,
                             ServerHttpResponse response,
                             WebSession webSession) {
        log.info("request: {}", request.getPath());
        log.info("request filter: {}", request.getHeaders().getFirst(TestWebFilter.FROM_FILTER));
        String requestId = request.getId();
        String sessionId = webSession.getId();
        response.setStatusCode(HttpStatusCode.valueOf(201));
        return Mono.just("请求ID:%s，会话ID：%s".formatted(requestId, sessionId));
    }

}
