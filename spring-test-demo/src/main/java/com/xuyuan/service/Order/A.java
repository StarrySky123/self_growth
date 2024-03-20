package com.xuyuan.service.Order;

import org.springframework.core.Ordered;

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
