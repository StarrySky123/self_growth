package com.xuyuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
//@Order
public class OrderService implements Ordered {

    /*@Autowired
    private SendService sendService;*/

    @Transactional
    public void test(){
//        sendService.test();
        //System.out.println("test");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
