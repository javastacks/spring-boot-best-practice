package cn.javastack.springboot.test.testcase;

import cn.javastack.springboot.test.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 微信公众号：Java技术栈
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MvcTests {

    @Test
    public void getUserTest(@Autowired TestRestTemplate testRestTemplate) {
        Map<String, String> multiValueMap = new HashMap<>();
        multiValueMap.put("username", "Java技术栈");
        Result result = testRestTemplate.getForObject("/user/get?username={username}",
                Result.class, multiValueMap);
        assertThat(result.getCode()).isEqualTo(0);
        assertThat(result.getMsg()).isEqualTo("ok");
    }

}