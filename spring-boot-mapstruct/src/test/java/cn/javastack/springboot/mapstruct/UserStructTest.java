package cn.javastack.springboot.mapstruct;

import cn.javastack.springboot.mapstruct.dto.UserShowDTO;
import cn.javastack.springboot.mapstruct.entity.User;
import cn.javastack.springboot.mapstruct.entity.UserExt;
import cn.javastack.springboot.mapstruct.struct.UserStruct;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
public class UserStructTest {

    @Test
    public void test1() {
        UserExt userExt = new UserExt();
        userExt.setRegSource("公众号：Java技术栈");
        userExt.setFavorite("写代码");
        userExt.setSchool("社会大学");

        User user = new User();
        user.setName("栈长");
        user.setSex(1);
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPhone("18888888888");
        user.setMarried(true);
        user.setRegDate(new Date());
        user.setMemo("666");
        user.setUserExt(userExt);

        UserShowDTO userShowDTO = UserStruct.INSTANCE.toUserShowDTO(user);
        System.out.println("=====单个对象映射=====");
        System.out.println(userShowDTO);

        List<User> users = new ArrayList<>();
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        user2.setName("栈长2");
        users.add(user);
        users.add(user2);
        List<UserShowDTO> userShowDTOS = UserStruct.INSTANCE.toUserShowDTOs(users);
        System.out.println("=====对象列表映射=====");
        userShowDTOS.forEach(System.out::println);
    }
}