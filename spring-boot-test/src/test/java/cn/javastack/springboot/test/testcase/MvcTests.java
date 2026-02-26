package cn.javastack.springboot.test.testcase;

import cn.javastack.springboot.test.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 微信公众号：Java技术栈
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MvcTests {

    @LocalServerPort
    private int port;

    @Test
    public void getUserTest() {
        RestClient client = RestClient.builder()
                .baseUrl("http://localhost:" + port)
                .build();
        Result result = client.get()
                .uri(uriBuilder -> uriBuilder.path("/user/get")
                        .queryParam("username", "Java技术栈")
                        .build())
                .retrieve()
                .body(Result.class);
        assertThat(result).isNotNull();
        assertThat(result.getCode()).isEqualTo(0);
        assertThat(result.getMsg()).isEqualTo("ok");
    }

}