package cn.javastack.springboot.test.testcase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootTest
@AutoConfigureMockMvc
class MockMvcTests {

    @Test
    public void getUserTest(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/get?username={username}", "test"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"code\":0,\"msg\":\"ok\",\"data\":\"test\"}"));
    }

}

