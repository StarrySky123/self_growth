package com.xuyuan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.xuyuan.service.UserService;

import java.lang.reflect.Field;

public class Test1 {

    public static void main(String[] args) {
        //bean对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext();
        UserService userService = (UserService)context.getBean("userService");
        userService.test();

        for (Field field : userService.getClass().getFields()) {
            if(field.isAnnotationPresent(Autowired.class)){

            }
        }
    }
}
