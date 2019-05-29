package dao;

import entities.Clas;
import entities.Student;

import java.util.ArrayList;

public interface ClasDao {
    ArrayList<Student> getAllStudents(Clas clas);

    void addStudent(Clas clas, Student student);
}
