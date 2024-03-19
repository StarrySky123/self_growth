package com.xuyuan.service;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class SendService implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void test(){
        String message = applicationContext.getMessage("test", null, new Locale("en"));
        System.out.println(message+"123");
        System.out.println("send");
    }


}
