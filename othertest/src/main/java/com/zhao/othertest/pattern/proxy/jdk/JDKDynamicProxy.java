package com.zhao.othertest.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用来获取代理对象
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object object;

    public JDKDynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy---->start  " + method.getName());
        Object invoke = method.invoke(object, args);
        System.out.println("Proxy---->end   " + method.getName());
        return invoke;
    }

    public <T> T  getProxy(Class T) {
        System.out.println(object.getClass().getInterfaces().length);
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }
}
