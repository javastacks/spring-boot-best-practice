package cn.javastack.springboot.actuator;

import cn.javastack.springboot.actuator.observation.IndexObservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@Slf4j
@Controller
public class LoginController {

    private final IndexObservation indexObservation;

    @GetMapping("/logout")
    public void logout() {
        log.info("log out...");
    }

    @GetMapping("/")
    @ResponseBody
    public String index() {
        log.info("this is index page.");
        indexObservation.observe();
        return "index page.";
    }

}
