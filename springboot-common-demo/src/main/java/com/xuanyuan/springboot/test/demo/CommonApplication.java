package com.xuanyuan.springboot.test.demo;

import com.xuanyuan.springboot.test.demo.component.ThirdDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonApplication{

    @Autowired
    ThirdDependency thirdDependency;

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

}
