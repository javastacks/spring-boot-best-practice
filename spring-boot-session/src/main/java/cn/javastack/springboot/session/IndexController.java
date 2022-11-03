package cn.javastack.springboot.session;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    /**
     * 登录页面
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login() {
        return "login page.";
    }

    /**
     * 登录请求
     * @param username
     * @return
     */
    @RequestMapping("/login/submit")
    public String loginSubmit(@RequestParam("username") String username) {
        if (StringUtils.isNotBlank(username)) {
            httpSession.setAttribute("username", username);
            return "/index";
        }
        return "/login";
    }

    /**
     * 首页
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        log.info("session id: {}", httpSession.getId());
        return "index page.";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        httpSession.invalidate();
        return "/login";
    }

}
