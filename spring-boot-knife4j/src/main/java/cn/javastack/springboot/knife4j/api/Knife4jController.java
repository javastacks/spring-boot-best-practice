package cn.javastack.springboot.knife4j.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Knife4j 测试接口
 * 来源微信公众号：Java技术栈
 * 作者：R哥
 */
@Tag(name = "测试模块")
@RestController
public class Knife4jController {

    /**
     * Knife4j 测试接口问好
     * 来源微信公众号：Java技术栈
     * 作者：R哥
     */
    @Operation(summary = "公众号Java技术栈向你问好！")
    @GetMapping("/knife4j/hi")
    public ResponseEntity<String> hello(@Parameter(description = "名称", required = true)
                                        @RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hi:" + name);
    }

    /**
     * Knife4j 测试接口登录
     * 来源微信公众号：Java技术栈
     * 作者：R哥
     */
    @Operation(summary = "接口登录！")
    @PostMapping("/knife4j/login")
    public ResponseEntity<String> login(@Parameter(description = "用户名", required = true)
                                        @RequestParam(value = "username") String username,
                                        @Parameter(description = "密码", required = true)
                                        @RequestParam(value = "password") String password) {
        if (StringUtils.isNotBlank(username) && "javastack".equals(password)) {
            return ResponseEntity.ok("登录成功:" + username);
        }
        return ResponseEntity.ok("用户名或者密码有误:" + username);
    }

}
