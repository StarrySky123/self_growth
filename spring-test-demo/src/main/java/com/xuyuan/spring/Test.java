package com.xuyuan.spring;

import com.xuyuan.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        //扫描 创建非懒加载单例bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();//jvm知识

        context.close();
    }
}
