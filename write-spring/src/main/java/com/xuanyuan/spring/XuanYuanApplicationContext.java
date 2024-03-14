package com.xuanyuan.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XuanYuanApplicationContext {

    private Class configClass;

    private Map<String,BeanDefinition> beanDefinitionMap  = new HashMap<>();
    private Map<String,Object> singletonObjects = new HashMap<>();
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public XuanYuanApplicationContext(Class configClass) {
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
            //没写完
            for (Field field : clazz.getDeclaredFields()) {
                if(field.isAnnotationPresent(Autowired.class)){
                    field.setAccessible(true);
                    field.set(instance,getBean(field.getName()));
                }
            }

            if (instance instanceof BeanNameAware) {
                ((BeanNameAware)instance).setBeanName(beanName);
            }

            for (Method method : clazz.getDeclaredMethods()) {
                if(method.isAnnotationPresent(PostConstruct.class)){
                    method.invoke(instance);
                }
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance,beanName);
            }

            if(instance instanceof InitializingBean){
                ((InitializingBean) instance).afterPropertiesSet();
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance,beanName);
            }

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
//            System.out.println(path);

            ClassLoader classLoader = XuanYuanApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());

            if(file.isDirectory()){
                for (File f : file.listFiles()) {
                    String absolutePath = f.getAbsolutePath();
                    absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                    absolutePath = absolutePath.replace("\\", ".");
//                    System.out.println(absolutePath);

                    try {
                        Class<?> clazz = classLoader.loadClass(absolutePath);
                        if(clazz.isAnnotationPresent(Component.class)){

                            if(BeanPostProcessor.class.isAssignableFrom(clazz)){
                                BeanPostProcessor instance = (BeanPostProcessor)clazz.getConstructor().newInstance();
                                beanPostProcessorList.add(instance);
                            }

                            Component componentAnnotation = clazz.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();
                            //bean
//                            System.out.println(clazz);
                            if("".equals(beanName)){
                                beanName = Introspector.decapitalize(clazz.getSimpleName());
                            }
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
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
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
            if(singletonBean == null){
                singletonObjects.put(beanName,createBean(beanName,beanDefinition));
            }
            return singletonBean;
        }else {
            //原型
            Object prototypeBean = createBean(beanName, beanDefinition);
            return prototypeBean;
        }
    }
}
