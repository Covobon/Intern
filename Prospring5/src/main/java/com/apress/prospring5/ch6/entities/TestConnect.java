package com.apress.prospring5.ch6.entities;

import com.apress.prospring5.ch6.config.EmbeddedJdbcConfig;
import com.apress.prospring5.ch6.dao.SingerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);

        SingerDao dao = context.getBean("singerDao", SingerDao.class);
    }
}
