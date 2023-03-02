package cn.javastack.springboot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 计算切面
 * 微信公众号：Java技术栈
 */
@Aspect
@Component
public class CalcAspect {

    @Pointcut("execution(* cn.javastack.springboot.aop.service.CalcService.*(..))")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("********** @Before 前置通知");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("******** @After 后置通知");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("******* @AfterReturning 返回通知");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("******** @AfterThrowing 异常通知");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        System.out.println("环绕通知之前");
        result = proceedingJoinPoint.proceed();
        System.out.println("环绕通知之后");
        return result;
    }

}