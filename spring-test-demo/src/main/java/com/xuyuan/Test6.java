package com.xuyuan;

import com.xuyuan.service.Order.A;
import com.xuyuan.service.Order.B;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.List;

public class Test6 {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        A a = new A();
        B b = new B();
//        OrderComparator comparator = new OrderComparator();
        AnnotationAwareOrderComparator comparator = new AnnotationAwareOrderComparator();
        System.out.println(comparator.compare(a,b));

        List list = new ArrayList<>();
        list.add(a);
        list.add(b);

        list.sort(comparator);
        System.out.println(list);


    }
}
