package services;

import dao.JdbcClasDao;
import dao.JdbcStudentDao;
import dao.JdbcTeacherDao;
import entities.Teacher;

import java.util.Scanner;

public class Run {
    private Teacher teacher;
    private JdbcTeacherDao jdbcTeacherDao;
    private JdbcStudentDao jdbcStudentDao;
    private JdbcClasDao jdbcClasDao;

    public void start(){
        loggin();
        manageStudent();
    }
/*
    private void execute() {
        Scanner in = new Scanner(System.in);
        loop:do {
            System.out.println("You loggined!\nChoose to use:\n" +
                    "1. Manage Student.\n" +
                    "2. Log out.\n" +
                    "Enter others to exit.");
            switch(in.nextInt()){
                case 1: {
                    manageStudent();
                    break;
                }
                case 2: {
                    break loop;
                }
                default: {
                    System.exit(0);
                }
            }
        }while(true);
    }*/

    private void manageStudent() {
        Scanner in = new Scanner(System.in);
        loop:do{
            System.out.println("Manage Student:\n" +
                    "1. Show students.\n" +
                    "2. Find students.\n" +
                    "3. Add student.\n" +
                    "4. Replace student.\n" +
                    "5. Remove student.\n" +
                    "6. Add class for student.\n" +
                    "7. Get class.\n" +
                    "Enter others to log out.");
            switch (in.nextInt()){
                case 1: {
                    showStudents();
                    break;
                }
                case 2: {
                    findStudents();
                    break;
                }
                case 3: {
                    addStudent();
                    break;
                }
                case 4: {
                    replaceStudent();
                    break;
                }
                case 5: {
                    removeStudent();
                    break;
                }
                case 6: {
                    addClass();
                    break;
                }
                case 7: {
                    getClass();
                    break;
                }
                default: {
                    break loop;
                }
            }
        }while(true);
    }

    private void addClass() {
    }

    private void removeStudent() {
    }

    private void replaceStudent() {
    }

    private void addStudent() {
    }

    private void findStudents() {
    }

    private void showStudents() {
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setJdbcTeacherDao(JdbcTeacherDao jdbcTeacherDao) {
        this.jdbcTeacherDao = jdbcTeacherDao;
    }

    private void loggin() {
        String account, firstName, lastName, email;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter account: ");
        account = in.nextLine();
        System.out.println("Enter first name: ");
        firstName = in.nextLine();
        System.out.println("Enter last name: ");
        lastName = in.nextLine();
        System.out.println("Enter email: ");
        email = in.nextLine();
        teacher = jdbcTeacherDao.loggin(account, firstName, lastName, email);
    }


}
