package cn.javastack.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class JavaTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void get() {
        Map<String, String> multiValueMap = new HashMap<>();
        multiValueMap.put("username", "Java技术栈");
        ActResult result = testRestTemplate.getForObject("/test/getUser?username={username}", ActResult.class, multiValueMap);
        Assert.assertEquals(result.getCode(), 0);
    }

    @Test
    public void post() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username", "Java技术栈");
        ActResult result = testRestTemplate.postForObject("/test/getUser", multiValueMap, ActResult.class);
        Assert.assertEquals(result.getCode(), 0);
    }


}