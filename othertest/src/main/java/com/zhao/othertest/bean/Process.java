package com.zhao.othertest.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

//@Component
public class Process implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Component 初始化 Bean Class:"+bean.getClass().getName()+"beanName"+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Component 初始化完成 Bean , Class:"+bean.getClass().getName()+"beanName:"+beanName);
        return bean;
    }
}
