package cn.javastack.springboot.mapstruct;

import cn.javastack.springboot.mapstruct.dto.UserMultiDTO;
import cn.javastack.springboot.mapstruct.entity.UserAddressDO;
import cn.javastack.springboot.mapstruct.entity.UserDO;
import cn.javastack.springboot.mapstruct.struct.UserMultiStruct;
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
public class UserMultiStructTest {

    @Autowired
    private UserMultiStruct userMultiStruct;

    @Test
    public void test1() {
        UserDO userDO = new UserDO();
        userDO.setName("多参数映射");
        userDO.setSex(1);
        userDO.setAge(18);
        userDO.setBirthday(new Date());
        userDO.setPhone("18888888888");
        userDO.setMarried(true);
        userDO.setRegDate(new Date());
        userDO.setMemo("666");

        UserAddressDO userAddressDO = new UserAddressDO();
        userAddressDO.setProvince("广东省");
        userAddressDO.setCity("深圳市");
        userAddressDO.setPostcode("666666");
        userAddressDO.setAddress("001号大街Java技术栈公众号");
        userAddressDO.setMemo("地址信息");

        UserMultiDTO userMultiDTO = userMultiStruct.toUserMultiDTO(userDO, userAddressDO);
        System.out.println("=====多参数映射=====");
        System.out.println(userMultiDTO);
    }
}