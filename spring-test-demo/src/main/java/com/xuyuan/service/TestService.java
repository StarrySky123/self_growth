package com.xuyuan.service;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class TestService implements DisposableBean {

    private MoneyService moneyService;

    public void printMoney(){
        System.out.println("money"+moneyService);
    }

    @Override
    public void destroy() throws Exception {

    }

    @PreDestroy
    public void destoryed(){
        System.out.println("销毁");
    }

    public void setMoneyService(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

}
