package com.xuyuan;

import com.xuyuan.service.OrderService;
import com.xuyuan.service.User;
import com.xuyuan.service.UserService;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyEditor;
import java.util.Collections;
import java.util.HashMap;

//@ComponentScan(value = "com.xuyuan",excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserService.class)})
@ComponentScan(value = "com.xuyuan",includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserService.class)})
//@ComponentScan(value = "com.xuyuan")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
@PropertySource("classpath:spring.properties")
public class AppConfig { //Appconfig代理对象 Configuration

    @Bean
    public OrderService orderService1(){
        return new OrderService();
    }

    @Bean
    public OrderService orderService2(){
        return new OrderService();
    }

    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConverter()));
        return conversionServiceFactoryBean;
    }

    /*@Bean
    public CustomEditorConfigurer customEditorConfigurer(){
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        HashMap<Class<?>, Class<? extends PropertyEditor>> propertyEditorMap = new HashMap<>();
        // 表示StringToUserPropertyEditor可以将String转化成User类型，在Spring源码中，如果发现当前对象是String，而需要的类型是User，就会使用该PropertyEditor来做类型转化
        propertyEditorMap.put(User.class,StringToUserPropertyEditor.class);
        customEditorConfigurer.setCustomEditors(propertyEditorMap);
        return customEditorConfigurer;
    }*/

    @Bean
    public ApplicationListener applicationListener(){
        return new ApplicationListener() {
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("接收到一个事件"+event.getSource());
            }
        };
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return  messageSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.162.111:3306/xuanyuan?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("ai710109");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return  transactionManager;
    }

}
