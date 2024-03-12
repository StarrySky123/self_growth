package com.xuyuan.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements InitializingBean {

    private OrderService orderService;

    public UserService(OrderService orderService) {
        this.orderService = orderService;
        System.out.println("2");
    }

    @Autowired
    public UserService(OrderService orderService1,OrderService orderService2) {
        this.orderService = orderService1;
        System.out.println("3");
    }

    public void test(){
        System.out.println("hello");

    }

    public void afterPropertiesSet() throws Exception {

    }
}
