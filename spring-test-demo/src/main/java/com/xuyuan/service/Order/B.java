package com.xuyuan.service.Order;

import org.springframework.core.Ordered;

public class B implements Ordered {
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
