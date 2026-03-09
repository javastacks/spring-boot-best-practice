package cn.javastack.springboot.session.webflux;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * 首页控制器
 * 微信公众号：Java技术栈
 */
@Slf4j
@Controller
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class IndexController {

    /**
     * 登录页面
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Mono<String> login() {
        return Mono.just("webflux login page.");
    }

    /**
     * 登录请求
     * @param username
     * @param webSession
     * @return
     */
    @RequestMapping("/login/submit")
    public Mono<Void> loginSubmit(@RequestParam("username") String username,
                                  WebSession webSession,
                                  ServerWebExchange exchange) {
        if (StringUtils.isNotBlank(username)) {
            webSession.getAttributes().put("username", username);
            return redirect(exchange, "/index");
        }
        return redirect(exchange, "/login");
    }

    /**
     * 首页
     * @param webSession
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public Mono<String> index(WebSession webSession) {
        log.info("session id: {}", webSession.getId());
        return Mono.just("webflux index page.");
    }

    /**
     * 退出登录
     * @param webSession
     * @return
     */
    @RequestMapping("/logout")
    public Mono<Void> logout(WebSession webSession, ServerWebExchange exchange) {
        return webSession.invalidate().then(redirect(exchange, "/login"));
    }

    private Mono<Void> redirect(ServerWebExchange exchange, String path) {
        exchange.getResponse().setStatusCode(HttpStatus.FOUND);
        exchange.getResponse().getHeaders().setLocation(URI.create(path));
        return exchange.getResponse().setComplete();
    }

}
