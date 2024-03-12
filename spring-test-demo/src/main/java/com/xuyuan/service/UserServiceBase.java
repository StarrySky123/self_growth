package com.xuyuan.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserServiceBase {

    @Transactional(propagation = Propagation.REQUIRED)
    public void  test3(){
        System.out.println("hello2");
    }
}
