package com.apress.springrecipes.shop;

import com.apress.springrecipes.shop.config.ShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderSupport;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
        String alert = context.getMessage("alert.checkout", null, Locale.US);
        String alert_inventory = context.getMessage("altert.inventory.checkout", new Object[] {
           "[DVD-RW 3.0]", new Date()
        }, Locale.US);
        System.out.println("The I18N message for alter.checkout is; " + alert);
        System.out.println("The I18N message for alter.inventory.checkout is: " + alert_inventory);
    }
}
