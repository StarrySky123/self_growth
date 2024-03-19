package com.xuyuan;

import com.xuyuan.service.SendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

public class Test4 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        /*Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
        System.out.println(systemEnvironment);
        System.out.println("=======");
        Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();
        System.out.println(systemProperties);
        System.out.println("=======");
        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        System.out.println(propertySources);
        System.out.println("=======");

        System.out.println(context.getEnvironment().getProperty("NO_PROXY"));
        System.out.println(context.getEnvironment().getProperty("sun.jnu.encoding"));
        System.out.println(context.getEnvironment().getProperty("a"));*/

//        context.publishEvent();
        SendService sendService = (SendService)context.getBean("sendService");
//        sendService.test();
    }
}
