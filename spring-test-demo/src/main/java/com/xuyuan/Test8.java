package com.xuyuan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test8 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("userService"));
    }
}
