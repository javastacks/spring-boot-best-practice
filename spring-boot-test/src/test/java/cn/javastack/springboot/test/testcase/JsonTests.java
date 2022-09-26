package cn.javastack.springboot.test.testcase;

import cn.javastack.springboot.test.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 微信公众号：Java技术栈
 */
@JsonTest
class JsonTests {

    @Autowired
    private JacksonTester<User> json;

    @Test
    void serialize() throws Exception {
        User user = new User(10001L, "Jack",
                LocalDateTime.of(2000, 10, 8, 21, 0, 0));
        assertThat(this.json.write(user)).isEqualToJson("/jack.json");
        assertThat(this.json.write(user)).hasJsonPathStringValue("@.name");
        assertThat(this.json.write(user)).
                extractingJsonPathStringValue("@.name").isEqualTo("Jack");
    }

    @Test
    void deserialize() throws Exception {
        String content = "{\"id\":10002, \"name\":\"Petty\", \"birthday\": \"2021-01-21T02:32:00\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new User(10002L, "Petty",
                        LocalDateTime.of(2021, 1, 21, 2, 32, 0)));
        assertThat(this.json.parseObject(content).getName()).isEqualTo("Petty");
    }

}

