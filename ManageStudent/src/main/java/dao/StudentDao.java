package dao;

import entities.Student;

import java.util.ArrayList;

public interface StudentDao {
    ArrayList<Student> getAllStudent();
    ArrayList<Student> findStudentsByFirstName(String firstName);
    ArrayList<Student> findStudentsByLastName(String lastName);
    Student findStudentByPhoneNumber(String phoneNumber);
    Student findStudentByEmail(String email);
    Student findStudentById(String id);

    void addStudent(Student student);
    void replaceStudent(Student student);
    void removeStudent(String value);
    void setClass(String value);
}
