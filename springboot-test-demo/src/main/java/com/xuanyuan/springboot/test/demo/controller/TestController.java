package com.xuanyuan.springboot.test.demo.controller;

import com.xuanyuan.springboot.test.demo.component.ThirdDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test (){
        return "这是一个好的开始";
    }

}
