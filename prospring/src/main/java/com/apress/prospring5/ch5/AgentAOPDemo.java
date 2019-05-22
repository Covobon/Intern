package com.apress.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String[] args) {
        Agent target = new Agent();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(target);

        Agent proxy = (Agent) pf.getProxy();

        target.speak();
<<<<<<< HEAD
        System.out.println("");
=======
        System.out.println(" ");
>>>>>>> b8376adec0c8443230540f89067f3247c11d887d
        proxy.speak();
    }
}
