package cn.javastack.springboot.test.testcase;

import cn.javastack.springboot.test.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootTest
class MockBeanTests {

//    @Autowired
//    private UserService userService;

    @MockitoBean
    private UserService userService;

    @Test
    public void countAllUsers() {
        BDDMockito.given(this.userService.countAllUsers()).willReturn(88);
        assertThat(this.userService.countAllUsers()).isEqualTo(88);
    }

}
