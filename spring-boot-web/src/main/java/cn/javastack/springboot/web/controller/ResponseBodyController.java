package cn.javastack.springboot.web.controller;

import cn.javastack.springboot.web.bean.OrderInfo;
import cn.javastack.springboot.web.bean.User;
import cn.javastack.springboot.web.bean.UserXml;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ResponseBodyController {

    @CrossOrigin
    @GetMapping(value = "/user/json/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getJsonUserInfo(@PathVariable("userId") String userId) {
        User user = new User("Java技术栈", 18);
        user.setId(Long.valueOf(userId));
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping(value = "/user/xml/{userId}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getXmlUserInfo(@PathVariable("userId") String userId) {
        UserXml user = new UserXml();
        user.setName("栈长");
        user.setId(userId);

        List<OrderInfo> orderList = new ArrayList<>();
        OrderInfo orderInfo1 = new OrderInfo("123456001", 999, new Date());
        OrderInfo orderInfo2 = new OrderInfo("123456002", 777, new Date());
        OrderInfo orderInfo3 = new OrderInfo("123456003", 666, new Date());
        orderList.add(orderInfo1);
        orderList.add(orderInfo2);
        orderList.add(orderInfo3);
        user.setOrderList(orderList);

        return new ResponseEntity(user, HttpStatus.OK);
    }


}
