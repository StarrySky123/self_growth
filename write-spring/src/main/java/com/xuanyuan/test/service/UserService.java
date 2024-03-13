package com.xuanyuan.test.service;

import com.xuanyuan.spring.Autowired;
import com.xuanyuan.spring.Component;
import com.xuanyuan.spring.Scope;

@Component("userService")
//@Scope("prototype")
//@Scope("singleton")
public class UserService {

    @Autowired
    private OrderService orderService;

    public void test(){
        System.out.println("spring test");
        System.out.println(orderService);
    }

}
