package com.apress.prospring5.ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSel")
public class InjectSimpleSpel {

    @Value("#{injectSimpleConfig.name}")
    private String name;
    @Value("#{injectSimpleConfig.age}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        InjectSimpleSpel simple = (InjectSimpleSpel) ctx.getBean("injectSimpleSpel");
        System.out.println(simple);
        ctx.close();
    }

    public String toString() {
        return "Name: " + name +
                "\nAge: " + age +
                "\nAge in seconds: " + ageInSeconds+
                "\nHeigh: " + height +
                "\nIs Programmer?:" + programmer;
    }
}
