package com.apress.prospring5.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Singer {
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

    public void init(){
        System.out.println("Initializing bean");

        if(name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You mus set the age property of any bean of type " + Singer.class);
        }
    }

    public String toString(){
        return "\tName: " + name + "\n\tAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static Singer getBean(String beanName, ApplicationContext ctx){
        try {
            Singer bean = ctx.getBean(beanName, Singer.class);
            System.out.println(bean);
            return bean;
        }catch(BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}
