package com.xuyuan;

import com.xuyuan.service.SendService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class Test3 {

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       /* DefaultListableBeanFactory beanfactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(SendService.class);
        beanfactory.registerBeanDefinition("sendService",beanDefinition);*/
       /* SendService sendService = (SendService)context.getBean("sendService");
        sendService.test();*/
        //国际化
        /*String message = context.getMessage("test", null, new Locale("en"));
        System.out.println(message);
*/
        /*Resource resource = context.getResource("spring.properties");
        try {
            File file = resource.getFile();
            URL url = resource.getURL();
            String file1 = url.getFile();
            if(file.isFile()){
                System.out.println("file");
            }
            System.out.println("----------"+resource.contentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*Resource resource = context.getResource("file://D:\\zyyangy\\workspace\\self_growth\\spring-test-demo\\src\\main\\java\\com\\xuyuan\\AppConfig.java");
        System.out.println(resource.contentLength());
        System.out.println(resource.getFilename());
        Resource resource1 = context.getResource("https://www.baidu.com");
        System.out.println(resource1.contentLength());
        System.out.println(resource1.getURL());
        System.out.println(resource1.getURL().getFile());
        Resource resource2 = context.getResource("classpath:spring.xml");
        System.out.println(resource2.contentLength());
        System.out.println(resource2.getURL());
        System.out.println(resource2.getURL().getFile());*/

    }
}
