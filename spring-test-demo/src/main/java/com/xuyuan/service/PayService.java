package com.xuyuan.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PayService {

    @Value("xuanyuan")
    private User user;

    public void test(){
        System.out.println(user.getName());
    }
}
