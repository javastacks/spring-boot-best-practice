package cn.javastack.springboot.mapstruct;

import cn.javastack.springboot.mapstruct.dto.UserShowDTO;
import cn.javastack.springboot.mapstruct.entity.User;
import cn.javastack.springboot.mapstruct.entity.UserExt;
import cn.javastack.springboot.mapstruct.struct.UserStructSpring;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStructSpringTest {

    @Autowired
    private UserStructSpring UserStructSpring;

    @Test
    public void test1() {
        UserExt userExt = new UserExt();
        userExt.setRegSource("公众号：Java技术栈");
        userExt.setFavorite("写代码");
        userExt.setSchool("社会大学");

        User user = new User();
        user.setName("栈长Spring");
        user.setSex(1);
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPhone("18888888888");
        user.setMarried(true);
        user.setRegDate(new Date());
        user.setMemo("666");
        user.setUserExt(userExt);

        UserShowDTO userShowDTO = UserStructSpring.toUserShowDTO(user);
        System.out.println("=====单个对象映射=====");
        System.out.println(userShowDTO);

        List<User> users = new ArrayList<>();
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        user2.setName("栈长Spring2");
        users.add(user);
        users.add(user2);
        List<UserShowDTO> userShowDTOS = UserStructSpring.toUserShowDTOs(users);
        System.out.println("=====对象列表映射=====");
        userShowDTOS.forEach(System.out::println);
    }
}