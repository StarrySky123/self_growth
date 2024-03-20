package com.xuyuan.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class XuanYuanBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("commodityService".equals(beanName)){
            System.out.println("初始化前"+bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("commodityService".equals(beanName)){
            System.out.println("初始化后"+bean);
        }
        return bean;
    }
}
