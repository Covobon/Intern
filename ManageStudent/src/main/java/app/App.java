package app;

import dao.JdbcStudentDao;
import dao.JdbcTeacherDao;
import entities.Clas;
import entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import services.Run;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final Logger LOGGER =
            LogManager.getLogger(JdbcStudentDao.class.getName());
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/configuration-bean.xml");
        context.refresh();
        Run run = context.getBean("run", Run.class);

        Scanner in = new Scanner(System.in);
        loop:do {
            System.out.println("You must loggin to use: \n" +
                    "1. Log in.\n" +
                    "2. Exit.");
            switch(in.nextInt()){
                case 1 : {
                    run.start();
                    break;
                }
                case 2 : {
                    break loop;
                }
            }
        } while(true);
        context.close();
    }
}
