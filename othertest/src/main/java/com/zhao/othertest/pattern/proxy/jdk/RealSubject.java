package com.zhao.othertest.pattern.proxy.jdk;

public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("do something....");
        notDo("xixixi");
    }

    @Override
    public int notDo(String name) {
        System.out.println(name);
        return 0;
    }
}
