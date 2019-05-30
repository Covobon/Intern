package dao;

import entities.Clas;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;

public interface StudentDao {
    ArrayList<Student> getAllStudent();
    ArrayList<Student> getStudentsByTeacher(Teacher teacher);
    ArrayList<Student> findStudentsByFirstName(String firstName);
    ArrayList<Student> findStudentsByLastName(String lastName);
    Student findStudentByPhoneNumber(String phoneNumber);
    Student findStudentByEmail(String email);
    Student findStudentById(String id);
    ArrayList<Student> findStudentsByValue(String value);

    void addStudent(Student student);
    void replaceStudent(Student student);
    void removeStudent(String value);
    void setClass(String value);
    void addToClas(Student student, Clas clas);
}
