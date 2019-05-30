package services;

import dao.JdbcTeacherDao;
import entities.Clas;
import entities.Teacher;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class ServiceTeacherImpl implements ServiceTeacher {

    private JdbcTeacherDao jdbcTeacherDao;

    public void setJdbcTeacherDao(JdbcTeacherDao jdbcTeacherDao) {
        this.jdbcTeacherDao = jdbcTeacherDao;
    }

    @Override
    public Teacher loggin() {
        Teacher teacher = null;
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
        try {
            teacher = jdbcTeacherDao.loggin(account, firstName, lastName, email);
        }catch (Exception e) {
            System.out.println("Error: Email is exists in database, email must is unique .");
        }
        return teacher;
    }

    @Override
    public void logout(Teacher teacher) {
        teacher = null;
    }

    @Override
    public void addClas(Teacher teacher, Clas clas) {

    }

    @Override
    public void getClas() {

    }
}
