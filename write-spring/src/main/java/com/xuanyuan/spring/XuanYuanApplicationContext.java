package com.xuanyuan.spring;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class XuanYuanApplicationContext {

    private Class configClass;

    private Map<String,BeanDefinition> beanDefinitionMap  = new HashMap<>();
    private Map<String,Object> singletonObjects = new HashMap<>();

    public XuanYuanApplicationContext(Class configClass) {
        this.configClass = configClass;
        //扫描
        scan(configClass);

        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if(beanDefinition.getScope().equals("singleton")){
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName,bean);
            }
        }
    }

    private Object createBean(String beanName,BeanDefinition beanDefinition){
        Class clazz = beanDefinition.getType();
        Object instance = null;
        try {
            instance = clazz.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }

    private void scan(Class configClass) {
        if(configClass.isAnnotationPresent((ComponentScan.class))){
            ComponentScan componentScanAnnotation = (ComponentScan)configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value();
            path = path.replace(".", "/"); // com/xuyuan/test/service
            System.out.println(path);

            ClassLoader classLoader = XuanYuanApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());

            if(file.isDirectory()){
                for (File f : file.listFiles()) {
                    String absolutePath = f.getAbsolutePath();
                    absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                    absolutePath = absolutePath.replace("\\", ".");
                    System.out.println(absolutePath);

                    try {
                        Class<?> clazz = classLoader.loadClass(absolutePath);
                        if(clazz.isAnnotationPresent(Component.class)){
                            Component componentAnnotation = clazz.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();
                            //bean
                            System.out.println(clazz);
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setType(clazz);
                            if(clazz.isAnnotationPresent(Scope.class)){
                                Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                String value = scopeAnnotation.value();
                                beanDefinition.setScope(value);
                            }else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName,beanDefinition);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Object getBean(String beanName){
        //beanName->UserService.class->

        if(!beanDefinitionMap.containsKey(beanName)){
            throw new NullPointerException();
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition.getScope().equals("singleton")){
            Object singletonBean = singletonObjects.get(beanName);
            return singletonBean;
        }else {
            //原型
            Object prototypeBean = createBean(beanName, beanDefinition);
            return prototypeBean;
        }
    }
}
