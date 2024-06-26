package com.xuanyuan.springboot.test.demo;

import com.xuanyuan.springboot.test.demo.component.ThirdDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//implements CommandLineRunner
public class SpringbootTestDemoApplication implements CommandLineRunner {

    @Autowired
    ThirdDependency thirdDependency;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTestDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        thirdDependency.test();
    }
}
