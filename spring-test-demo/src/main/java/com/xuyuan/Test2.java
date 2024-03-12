package com.xuyuan;

import com.xuyuan.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = (OrderService)context.getBean("orderService");
        orderService.test();
    }
}
