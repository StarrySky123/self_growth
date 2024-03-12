package com.xuyuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderService {

    @Autowired
    private SendService sendService;

    @Transactional
    public void test(){
        sendService.test();
        //System.out.println("test");
    }

}
