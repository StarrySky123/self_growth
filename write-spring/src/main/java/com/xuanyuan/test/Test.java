package com.xuanyuan.test;

import com.xuanyuan.spring.XuanYuanApplicationContext;
import com.xuanyuan.test.service.UserService;

public class Test {

    public static void main(String[] args) {
        //扫描->创建单例bean
        XuanYuanApplicationContext applicationContext = new XuanYuanApplicationContext(AppConfig.class);

        UserService userService = (UserService) applicationContext.getBean("userService");
    }
}
