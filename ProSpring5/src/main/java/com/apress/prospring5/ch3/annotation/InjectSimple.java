package com.apress.prospring5.ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
    @Value("John Mayer")
    private String name;

    @Value("39")
    private int age;

    @Value("1.92")
    private float height;

    @Value("false")
    private boolean programmer;

    @Value("1234123412")
    private long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
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
