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

    public void test(){
//        System.out.println("spring test");
//        System.out.println(orderService);
        System.out.println(beanName);
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
