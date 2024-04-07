package com.xuanyuan.springboot.test.demo.component;

import org.springframework.stereotype.Component;

@Component
public class ThirdDependency {

    public void test(){
        System.out.println("third-dependency");
    }
}
