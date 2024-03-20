package com.xuyuan;

import com.xuyuan.service.OrderService;
import com.xuyuan.service.SendService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.register();
       /* OrderService orderService = (OrderService)context.getBean("orderService");
        orderService.test();*/

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(SendService.class);
        beanDefinition.setScope("prototype");
        context.registerBeanDefinition("sendService",beanDefinition);

        SendService sendService = (SendService)context.getBean("sendService");

        /*AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        annotatedBeanDefinitionReader.register(SendService.class);
        SendService sendService = (SendService)context.getBean("sendService");*/

        /*XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
        int i = xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");*/

       /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register();
        context.scan();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
        context.refresh();
        int scan = scanner.scan("com.xuyuan");*/
        /*SendService sendService = (SendService)context.getBean("sendService");
        sendService.test();
*/
    }
}
