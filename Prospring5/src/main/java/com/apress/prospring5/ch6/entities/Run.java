package com.apress.prospring5.ch6.entities;

import com.apress.prospring5.ch6.config.EmbeddedJdbcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Run {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
    }
}
