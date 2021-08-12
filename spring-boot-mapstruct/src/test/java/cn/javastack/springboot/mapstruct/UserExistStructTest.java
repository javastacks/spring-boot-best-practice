package cn.javastack.springboot.mapstruct;

import cn.javastack.springboot.mapstruct.dto.UserShowDTO;
import cn.javastack.springboot.mapstruct.entity.UserDO;
import cn.javastack.springboot.mapstruct.entity.UserExtDO;
import cn.javastack.springboot.mapstruct.struct.UserExistStruct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserExistStructTest {

    @Autowired
    private UserExistStruct userExistStruct;

    @Test
    public void test1() {
        UserExtDO userExtDO = new UserExtDO();
        userExtDO.setRegSource("公众号：Java技术栈");
        userExtDO.setFavorite("写代码");
        userExtDO.setSchool("社会大学");

        UserDO userDO = new UserDO();
        userDO.setName("栈长");
        userDO.setSex(1);
        userDO.setAge(18);
        userDO.setBirthday(new Date());
        userDO.setPhone("18888888888");
        userDO.setMarried(true);
        userDO.setRegDate(new Date());
        userDO.setMemo("666");
        userDO.setUserExtDO(userExtDO);

        System.out.println("=====映射现有实例前=====");
        UserShowDTO userShowDTO = new UserShowDTO();
        userShowDTO.setName("栈长NAME");
        userShowDTO.setMemo("栈长MEMO");
        System.out.println(userShowDTO);

        System.out.println("=====映射现有实例后=====");
        userExistStruct.toUserShowDTO(userShowDTO, userDO);
        System.out.println(userShowDTO);
    }
}