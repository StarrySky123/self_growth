package com.xuanyuan.test.service;

import com.xuanyuan.spring.Component;
import com.xuanyuan.spring.Scope;

@Component("userService")
@Scope("prototype")
public class UserService {

    public void test(){
        System.out.println("spring test");
    }

}
