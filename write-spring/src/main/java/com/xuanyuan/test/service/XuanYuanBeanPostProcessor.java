package com.xuanyuan.test.service;

import com.xuanyuan.spring.BeanPostProcessor;
import com.xuanyuan.spring.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class XuanYuanBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (beanName.equals("userService")) {
            Object proxyInstance = Proxy.newProxyInstance(XuanYuanBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    //切面
//                    System.out.println("post"+"->"+beanName);
                    System.out.println("切面逻辑");
                    return method.invoke(bean,args);
                }
            });
            return proxyInstance;
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(XuanYuanValue.class)){
                field.setAccessible(true);
                try {
                    field.set(bean,field.getAnnotation(XuanYuanValue.class).value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
