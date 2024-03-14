package com.xuanyuan.test.service;

import com.xuanyuan.spring.*;

@Component("userService")
//@Scope("prototype")
//@Scope("singleton")
public class UserService implements InitializingBean,UserInterface, BeanNameAware {

    @Autowired
    private OrderService orderService;

    @XuanYuanValue("test")
    private String test;

    private String beanName;

    @PostConstruct
    public void init(){
        System.out.println("post method");
    }

    public void test(){
//        System.out.println("spring test");
//        System.out.println(orderService);
        System.out.println(orderService);
    }

    @Override
    public void afterPropertiesSet() {
//        System.out.println("初始化");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
