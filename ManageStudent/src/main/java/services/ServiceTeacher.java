package services;

import entities.Clas;
import entities.Teacher;

public interface ServiceTeacher {
    Teacher loggin();
    void logout(Teacher teacher);
    void addClas(Teacher teacher, Clas clas);

    void getClas();
}
