package com.apress.springrecipes.sequence;

import com.apress.springrecipes.shop.Product;
import com.apress.springrecipes.shop.config.ShopConfiguration;
import com.apress.springrecipes.sequence.config.SequenceGeneratorConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
        Product aaa = context.getBean("aaa", Product.class);
        Product cdew = context.getBean("cdrw", Product.class);
        System.out.println(aaa.toString());
        System.out.println(cdew.toString());
    }
}
