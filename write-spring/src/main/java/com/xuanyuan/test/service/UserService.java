package com.xuanyuan.test.service;

import com.xuanyuan.spring.Autowired;
import com.xuanyuan.spring.Component;
import com.xuanyuan.spring.InitializingBean;
import com.xuanyuan.spring.Scope;

@Component("userService")
//@Scope("prototype")
//@Scope("singleton")
public class UserService implements InitializingBean,UserInterface {

    @Autowired
    private OrderService orderService;

    @XuanYuanValue("test")
    private String test;

    public void test(){
//        System.out.println("spring test");
//        System.out.println(orderService);
        System.out.println(test);
    }

    @Override
    public void afterPropertiesSet() {
//        System.out.println("初始化");
    }
}
