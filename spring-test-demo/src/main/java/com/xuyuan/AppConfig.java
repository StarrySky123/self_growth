package com.xuyuan;

import com.xuyuan.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan("com.xuyuan")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
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
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate();
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.162.111:3306/xuyuan?characterEncoding=utf-8&amp;useSSL=false");
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
