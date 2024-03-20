package com.xuyuan.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserService implements InitializingBean {

    private OrderService orderService;

    @Autowired
    private OrderService orderService2;

    @Autowired
    UserServiceBase userServiceBase;

    @Autowired
    UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserService(OrderService orderService) {
        this.orderService = orderService;
        System.out.println("2");
    }

    @Autowired
    public UserService(OrderService orderService1,OrderService orderService2) {
        this.orderService = orderService1;
        System.out.println("3");
    }

    @Transactional
    public void test(){
        System.out.println("hello");
        jdbcTemplate.execute("insert into user_info values(null,'zyyangy',18,'男','123456',null,null)");
        userService.test2();
//        throw new NullPointerException();

    }

    @Transactional(propagation = Propagation.NEVER)
    public void  test2(){
        System.out.println("hello2");
    }

    public void afterPropertiesSet() throws Exception {

    }
}
