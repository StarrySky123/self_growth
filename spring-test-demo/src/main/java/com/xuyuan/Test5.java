package com.xuyuan;

import com.xuyuan.service.PayService;
import com.xuyuan.service.SendService;
import com.xuyuan.service.User;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;

public class Test5 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PayService sendService = (PayService)context.getBean("payService",PayService.class);
        sendService.test();

        /*StringToUserPropertyEditor propertyEditor = new StringToUserPropertyEditor();
        propertyEditor.setAsText("1");
        User user = (User) propertyEditor.getValue();
        System.out.println(user);
        System.out.println(user.getName());*/

        /*DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToUserConverter());
        User value = conversionService.convert("1", User.class);
        System.out.println(value.getName());*/

       /* SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        typeConverter.registerCustomEditor(User.class,new StringToUserPropertyEditor());
//        typeConverter.setConversionService(conversionService);
        User user = typeConverter.convertIfNecessary("1", User.class);
        System.out.println(user);*/
    }
}
