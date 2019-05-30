package services;

import dao.JdbcStudentDao;
import entities.Clas;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceStudentImpl implements ServiceStudent{

    private Scanner in = new Scanner(System.in);

    private JdbcStudentDao jdbcStudentDao;
    public void setJdbcStudentDao(JdbcStudentDao jdbcStudentDao) {
        this.jdbcStudentDao = jdbcStudentDao;
    }
    @Override
    public void removeClass(Student student, Clas clas) {
        ArrayList<Clas> clases = student.getClas();
        for (int i = 0; i < clases.size(); i++){
            if (clases.get(i).getId() ==  clas.getId())
                clases.remove(i);
        }
    }

    @Override
    public void addClass(Student student, Clas clas) {
        student.getClas().add(clas);
    }

    @Override
    public void showStudentByTeacher(Teacher teacher) {
        ArrayList<Student> students = new ArrayList<>();
        students = jdbcStudentDao.getStudentsByTeacher(teacher);
        for(Student student : students) {
            System.out.println(student.showInfo());
        }
        if (students.size() == 0) {
            System.out.println("Not found");
        }
    }

    @Override
    public void findStudent() {
        loop:do {
            System.out.println("Find student by: \n" +
                    "1. Id. \n" +
                    "2. Email. \n" +
                    "3. Phone number. \n" +
                    "4. Value.\n" +
                    "Enter orther to exit.");
            String flag = in.nextLine();
            switch(Integer.parseInt(flag)){
                case 1:{
                    System.out.println("Enter Id: ");
                    Student student = jdbcStudentDao.findStudentById(in.nextLine());
                    if (student == null) {
                        System.out.println("Not found.");
                    } else {
                        System.out.println(student.showInfo());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter Email: ");
                    Student student = jdbcStudentDao.findStudentByEmail(in.nextLine());
                    if (student == null) {
                        System.out.println("Not found");
                    } else System.out.println(student.showInfo());
                    break;
                }
                case 3: {
                    System.out.println("Enter phone number: ");
                    Student student = jdbcStudentDao.findStudentByPhoneNumber(in.nextLine());
                    if (student == null){
                        System.out.println("Not found!");
                    }else System.out.println(student.showInfo());
                    break;
                }
                case 4: {
                    System.out.println("Input something value: ");
                    ArrayList<Student> students = jdbcStudentDao.findStudentsByValue(in.nextLine());
                    if (students.size() == 0) {
                        System.out.println("Not found");
                    }
                    else {
                        for (Student student : students){
                            System.out.println(student.showInfo());
                        }
                    }
                    break;
                }
                default:{
                    break loop;
                }

            }
        } while (true);
    }

    @Override
    public void addStudent() {
        String id, firstName, lastName, email, phoneNumber;
        System.out.println("Enter id student ");
        id = in.nextLine();
        System.out.println("Enter first name: ");
        firstName = in.nextLine();
        System.out.println("Enter last name: ");
        lastName = in.nextLine();
        System.out.println("Enter email: ");
        email = in.nextLine();
        System.out.println("Enter phone number: ");
        phoneNumber = in.nextLine();
        Student student = new Student(id, firstName, lastName, phoneNumber, email);
        jdbcStudentDao.addStudent(student);
    }

    @Override
    public void replaceStudent() {
        String id, firstName, lastName, email, phoneNumber;
        System.out.println("Enter id to choose student replace: ");
        id = in.nextLine();
        System.out.println("Enter first name replace: ");
        firstName = in.nextLine();
        System.out.println("Enter last name replace: ");
        lastName = in.nextLine();
        System.out.println("Enter email replace: ");
        email = in.nextLine();
        System.out.println("Enter phone number replace: ");
        phoneNumber = in.nextLine();
        Student student = new Student(id, firstName, lastName, phoneNumber, email);
        jdbcStudentDao.replaceStudent(student);
    }

    @Override
    public void removeStudent() {
        System.out.println("Enter id, email or phone number to remove: ");
        String value = in.nextLine();
        jdbcStudentDao.removeStudent(value);
    }

    @Override
    public void addToClas() {
        String idStudent, idClass;
        System.out.println("Enter id to choose student: ");
        idStudent = in.nextLine();
        Student student = jdbcStudentDao.findStudentById(idStudent);
        System.out.println("Enter id class: ");
        idClass = in.nextLine();
        Clas clas = new Clas(idClass);
        jdbcStudentDao.addToClas(student, clas);
    }


}
