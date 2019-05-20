package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    private String name;
    private int age;
    private float heigh;
    private boolean programmer;
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        InjectSimple simple = (InjectSimple) ctx.getBean("/home/covobon/IdeaProjects/ProSpring5/src/com/apress/prospring5/spring/app-context-xml.xml");
        System.out.println(simple);
        ctx.close();
    }

    public void setAgeInSeconds(Long ageInSeconds){
        this.ageInSeconds = ageInSeconds;
    }

    public void setProgrammer(boolean programmer){
        this.programmer = programmer;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setHeigh(float heigh){
        this.heigh = heigh;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString() {
        return "Name: " + name +
                "\nAge: " + age +
                "\nAge in seconds: " + ageInSeconds+
                "\nHeigh: " + heigh +
                "\nIs Programmer?:" + programmer;
    }
}
