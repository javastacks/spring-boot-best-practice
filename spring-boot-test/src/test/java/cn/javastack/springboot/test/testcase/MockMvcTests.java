package cn.javastack.springboot.test.testcase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootTest
class MockMvcTests {

    private MockMvc mvc;

    @BeforeEach
    void setUp(WebApplicationContext context) {
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getUserTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/get?username={username}", "test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.msg").value("ok"))
                .andExpect(jsonPath("$.data").value("test"));
    }

}
