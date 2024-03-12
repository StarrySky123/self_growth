package com.xuyuan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.xuyuan.service.UserService;
import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {

    public static void main(String[] args) {
        //bean对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext();
        UserService userService = (UserService)context.getBean("userService");
      /*  System.out.println(context.getBean("orderService"));
        System.out.println(context.getBean("orderService1"));
        System.out.println(context.getBean("orderService2"));*/
        userService.test();

        /*for (Field field : userService.getClass().getFields()) {
            if(field.isAnnotationPresent(Autowired.class)){
                //field.set(userService,??);
            }
        }

        for (Method method : userService.getClass().getMethods()) {
            if(method.isAnnotationPresent(PostConstruct.class)){
                try {
                    method.invoke(userService,null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
