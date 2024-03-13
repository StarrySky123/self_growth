package com.xuanyuan.test.service;

import com.xuanyuan.spring.BeanPostProcessor;
import com.xuanyuan.spring.Component;

@Component
public class XuanYuanBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("post"+"->"+beanName);
        return bean;
    }
}
