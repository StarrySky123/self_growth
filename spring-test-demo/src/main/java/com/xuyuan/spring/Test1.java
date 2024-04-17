package com.xuyuan.spring;

import com.xuyuan.AppConfig;
import com.xuyuan.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestService testService = (TestService)context.getBean("testService");

       testService.printMoney();
    }
}
