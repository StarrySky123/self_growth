package com.xuyuan.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class UserService implements InitializingBean {

    private OrderService orderService;

    public UserService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void test(){
        System.out.println("hello");

    }

    public void afterPropertiesSet() throws Exception {

    }
}
