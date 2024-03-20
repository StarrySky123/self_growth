package com.xuyuan.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("commodityService")
public class XuanYuanFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        CommodityService commodityService = new CommodityService();
        return commodityService;
    }

    @Override
    public Class<?> getObjectType() {
        return CommodityService.class;
    }
}
