package com.apress.prospring5.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements  MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Jame");

        Object retVal = methodInvocation.proceed();

        System.out.print("!");

        return retVal;
    }
}
