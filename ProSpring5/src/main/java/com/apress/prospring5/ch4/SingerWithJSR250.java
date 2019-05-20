package com.apress.prospring5.ch4;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithJSR250 {
    private static final String DEFAULT_NAME = "Eric Clapton";

    private String name;
    private int age = Integer.MIN_VALUE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Initialzing bean");

        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException(
                    "You mus set the age property of any beans of type " + SingerWithJSR250.class
            );
        }
    }

    @Override
    public String toString(){
        return "\tName: " + name + "\n\tAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        getBean("singerOne", ctx );
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();
    }

    private static SingerWithJSR250 getBean(String beanName, GenericXmlApplicationContext ctx) {
        try{
            SingerWithJSR250 bean = ctx.getBean(beanName, SingerWithJSR250.class);
            System.out.println(bean);
            return bean;
        }catch(BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}
