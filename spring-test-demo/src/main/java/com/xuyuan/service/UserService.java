package com.xuyuan.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService implements InitializingBean {

    private OrderService orderService;

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
        jdbcTemplate.execute("insert into t1 values(1,1,1,1,1)");
        throw new NullPointerException();

    }

    public void afterPropertiesSet() throws Exception {

    }
}
