package app;

import dao.JdbcStudentDao;
import dao.JdbcTeacherDao;
import entities.Clas;
import entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final Logger LOGGER =
            LogManager.getLogger(JdbcStudentDao.class.getName());
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/configuration-bean-dao.xml");
        context.refresh();

        Teacher teacher  = null;
        JdbcTeacherDao jdbcTeacherDao = context.getBean("jdbcTeacherDao", JdbcTeacherDao.class);
        Scanner in = new Scanner(System.in);
        loop:do {
            System.out.println("You must loggin to use: \n" +
                    "1. Log in.\n" +
                    "2. Exit.");
            switch(in.nextInt()){
                case 1 : {
                    teacher = loggin(jdbcTeacherDao);
                    execute(teacher);
                    break;
                }
                case 2 : {
                    break loop;
                }
            }
        } while(true);
    }

    private static void execute(Teacher teacher) {
        root:do{
        System.out.println("Choose to use: \n" +
                "1. Show all students managed by you.\n" +
                "2. Filter by class:\n" +
                "3. Manage student.\n" +
                "Enter anything to log out.");
        Scanner in = new Scanner(System.in);
        switch(in.nextInt()){
            case 1: {
                showAllStudents();
                break;
            }
            case 2: {
                showStudentsByClass(teacher);
                break;
            }
            case 3: {
                manageStudent();
                break;
            }
            default: {
                break root;
            }
        }
        } while(true);
    }

    private static void manageStudent() {
    }

    private static void showStudentsByClass(Teacher teacher) {
        ArrayList<Clas> clases = teacher.getClas();
        for (Clas clas : clases) {
            System.out.println("Id: " + clas.getId() + "Class name: "+ clas.getName());
        }
        System.out.println("Enter Id to choose class");

    }

    private static void showAllStudents() {
    }

    private static Teacher loggin(JdbcTeacherDao jdbc ) {
        System.out.println("Nhap lan luot Account, First Name, Last Name and Email");
        Scanner in = new Scanner(System.in);
        String account, firstName, lastName, email;
        account = in.nextLine();
        firstName = in.nextLine();
        lastName = in.nextLine();
        email = in.next();
        return jdbc.loggin(account, firstName, lastName, email);
    }

    private static void logout(Teacher teacher) {
        teacher = null;
    }
}
