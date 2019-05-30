package services;

import dao.JdbcClasDao;
import dao.JdbcStudentDao;
import dao.JdbcTeacherDao;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    private Teacher teacher;
    private ServiceTeacher serviceTeacher;
    private ServiceStudent serviceStudent;

    public void setServiceTeacher(ServiceTeacher serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }

    public void setServiceStudent(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public void start(){
        this.teacher = serviceTeacher.loggin();
        if(teacher != null) {
            manageStudent(teacher);
        }
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

    private void manageStudent(Teacher teacher) {
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
            switch (in.nextLine()){
                case "1": {
                    serviceStudent.showStudentByTeacher(teacher);
                    break;
                }
                case "2": {
                    serviceStudent.findStudent();
                    break;
                }
                case "3": {
                    serviceStudent.addStudent();
                    break;
                }
                case "4": {
                    serviceStudent.replaceStudent();
                    break;
                }
                case "5": {
                    serviceStudent.removeStudent();
                    break;
                }
                case "6": {
                    serviceStudent.addToClas();
                    break;
                }
                case "7": {
                    serviceTeacher.getClas();
                    break;
                }
                default: {
                    break loop;
                }
            }
        }while(true);
    }
}
