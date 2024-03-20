package com.xuyuan.service.Order;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

//@Order(3)
public class A implements Ordered {
    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
