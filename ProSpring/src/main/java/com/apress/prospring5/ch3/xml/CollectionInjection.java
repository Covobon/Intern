package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
        instance.dispalyInfo();

        ctx.close();
    }

    private void dispalyInfo() {
        System.out.println("Map contents:\n");
        map.entrySet().stream().forEach(e -> System.out.println(
                "Key: " + e.getKey() + " - Value: " + e.getValue()
        ));

        System.out.println("\nProperties contest:\n");
        props.entrySet().stream().forEach(e -> System.out.println(
                "Key: " + e.getKey() + " - Value: " + e.getValue()
        ));

        System.out.println("\nSet contest:\n");
        set.forEach(obj -> System.out.println("Value: " + obj));

        System.out.println("\nList contents:\n");
        list.forEach(obj -> System.out.println("Value: " + obj));
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
