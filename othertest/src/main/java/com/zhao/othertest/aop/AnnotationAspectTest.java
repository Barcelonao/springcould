package com.zhao.othertest.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspectTest {

    @Pointcut("execution(* *.action(*))")
    public void action() {
    }

    @Pointcut("execution(* *.work(*))")
    public void work() {
    }

    @Pointcut("action() || work())")
    public void compositePointcut() {
    }

    //前置通知
    @Before("compositePointcut()")
    public void beforeAdvice() {
        System.out.println("before advice.................");
    }

    //后置通知
    @After("compositePointcut()")
    public void doAfter() {
        System.out.println("after advice..................");
    }
}
