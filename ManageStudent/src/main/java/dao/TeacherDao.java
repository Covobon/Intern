package dao;

import entities.Clas;
import entities.Teacher;

public interface TeacherDao {
    Teacher loggin(String account, String firstName, String lastName, String email);
    void getClas(Teacher teacher, Clas clas);
}
