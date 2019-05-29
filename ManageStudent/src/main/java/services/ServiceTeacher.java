package services;

import entities.Clas;
import entities.Teacher;

public interface ServiceTeacher {
    void logout(Teacher teacher);
    void addClass(Teacher teacher, Clas clas);
}
