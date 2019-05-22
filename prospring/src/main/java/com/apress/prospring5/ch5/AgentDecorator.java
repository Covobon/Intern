package com.apress.prospring5.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

<<<<<<< HEAD
public class AgentDecorator implements  MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Jame");
=======
public class AgentDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("James ");
>>>>>>> b8376adec0c8443230540f89067f3247c11d887d

        Object retVal = methodInvocation.proceed();

        System.out.print("!");
<<<<<<< HEAD

=======
>>>>>>> b8376adec0c8443230540f89067f3247c11d887d
        return retVal;
    }
}
