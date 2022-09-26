package cn.javastack.springboot.mapstruct;

import cn.javastack.springboot.mapstruct.dto.UserNestedDTO;
import cn.javastack.springboot.mapstruct.entity.UserAddressDO;
import cn.javastack.springboot.mapstruct.entity.UserExtDO;
import cn.javastack.springboot.mapstruct.entity.UserNestedDO;
import cn.javastack.springboot.mapstruct.struct.UserNestedStruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * 微信公众号：Java技术栈
 *
 * @author 栈长
 */
@SpringBootTest
public class UserNestedStructTest {

    @Autowired
    private UserNestedStruct userNestedStruct;

    @Test
    public void test1() {
        UserExtDO userExtDO = new UserExtDO();
        userExtDO.setRegSource("公众号：Java技术栈");
        userExtDO.setFavorite("写代码");
        userExtDO.setSchool("社会大学");
        userExtDO.setKids(1);
        userExtDO.setMemo("扩展信息");

        UserAddressDO userAddressDO = new UserAddressDO();
        userAddressDO.setProvince("广东省");
        userAddressDO.setCity("深圳市");
        userAddressDO.setPostcode("666666");
        userAddressDO.setAddress("001号大街Java技术栈公众号");
        userAddressDO.setMemo("地址信息");

        UserNestedDO userNestedDO = new UserNestedDO();
        userNestedDO.setName("栈长嵌套映射");
        userNestedDO.setSex(1);
        userNestedDO.setAge(18);
        userNestedDO.setBirthday(new Date());
        userNestedDO.setPhone("18888888888");
        userNestedDO.setMarried(true);
        userNestedDO.setRegDate(new Date());
        userNestedDO.setMemo("666");
        userNestedDO.setUserExtDO(userExtDO);
        userNestedDO.setUserAddressDO(userAddressDO);

        UserNestedDTO userNestedDTO = userNestedStruct.toUserNestedDTO(userNestedDO);
        System.out.println("=====嵌套映射=====");
        System.out.println(userNestedDTO);
    }
}