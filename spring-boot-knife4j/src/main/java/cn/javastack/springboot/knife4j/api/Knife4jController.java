package cn.javastack.springboot.knife4j.api;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Knife4j 测试接口
 * 来源微信公众号：Java技术栈
 * 作者：栈长
 */
@Api(tags = "测试模块")
@RestController
public class Knife4jController {

    /**
     * Knife4j 测试接口问好
     * 来源微信公众号：Java技术栈
     * 作者：栈长
     */
    @ApiImplicitParam(name = "name", value = "名称", required = true)
    @ApiOperation(value = "公众号Java技术栈向你问好！")
    @ApiOperationSupport(order = 2, author = "栈长")
    @GetMapping("/knife4j/hi")
    public ResponseEntity<String> hello(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hi:" + name);
    }

    /**
     * Knife4j 测试接口登录
     * 来源微信公众号：Java技术栈
     * 作者：栈长
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @ApiOperation(value = "接口登录！")
    @ApiOperationSupport(order = 1, author = "栈长")
    @PostMapping("/knife4j/login")
    public ResponseEntity<String> login(@RequestParam(value = "username") String username,
                                        @RequestParam(value = "password") String password) {
        if (StringUtils.isNotBlank(username) && "javastack".equals(password)) {
            return ResponseEntity.ok("登录成功:" + username);
        }
        return ResponseEntity.ok("用户名或者密码有误:" + username);
    }

}