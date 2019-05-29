package services;

import entities.Clas;
import entities.Teacher;

public class ServiceTeacherImpl implements ServiceTeacher {
    @Override
    public void logout(Teacher teacher) {
        teacher = null;
    }

    @Override
    public void addClass(Teacher teacher, Clas clas) {
        teacher.getClas().add(clas);
    }
}
