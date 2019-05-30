package dao;

import entities.Clas;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;

public interface ClasDao {
    ArrayList<Student> getAllStudents(Clas clas);
    void addStudent(Clas clas, Student student);
    ArrayList<Clas> getClasesByTeacher(Teacher teacher);
    ArrayList<Clas> getClassesByStudent(Student student);

    void openClas(Clas clas, Teacher teacher);
}
