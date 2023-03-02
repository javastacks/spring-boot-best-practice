package cn.javastack.springboot.aop.service;

import org.springframework.stereotype.Service;

/**
 * 计算服务实现
 * 微信公众号：Java技术栈
 */
@Service
public class CalcServiceImpl implements CalcService {

    @Override
    public int divide(int x, int y) {
        System.out.println("=========== CalcService 被调用了");
        int result = x / y;
        System.out.println("=========== CalcService 调用成功");
        return result;
    }

}

