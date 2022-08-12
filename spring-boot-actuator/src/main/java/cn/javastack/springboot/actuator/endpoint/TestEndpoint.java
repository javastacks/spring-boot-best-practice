package cn.javastack.springboot.actuator.endpoint;

import cn.javastack.springboot.actuator.pojo.User;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * 微信公众号：Java技术栈
 */
@Component
@WebEndpoint(id = "test")
public class TestEndpoint {

    @ReadOperation
    public User getUser(@Selector Integer id) {
        return new User(id, "james", 18);
    }

    @WriteOperation
    public User updateUser(int id, @Nullable String name, @Nullable Integer age) {
        User user = getUser(id);
        user.setName(StringUtils.defaultIfBlank(name, user.getName()));
        user.setAge(ObjectUtils.defaultIfNull(age, user.getAge()));
        return user;
    }

}
