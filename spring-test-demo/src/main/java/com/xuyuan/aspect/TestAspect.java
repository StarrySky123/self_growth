package com.xuyuan.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Before("execution(public void com.xuyuan.service.UserService.test())")
    public void testBefore(JoinPoint joinPoint){
        System.out.println("test before");
    }
}
