package com.zhao.othertest.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    public String action(String msg) {
        System.out.println("FooService, method doing.");

        ((IPersonService) AopContext.currentProxy()).work(msg);

        //this.work(msg);

        return "[" + msg + "]";
    }

    @Override
    public String work(String msg) {
        System.out.println("work: * " + msg + " *");
        return "* " + msg + " *";
    }

}
