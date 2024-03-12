package com.xuyuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private SendService sendService;

    public void test(){
        sendService.test();
        //System.out.println("test");
    }

}
