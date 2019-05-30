

package services;

import entities.Clas;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;

public interface ServiceStudent {
    void removeClass(Student student, Clas clas);
    void addClass(Student student, Clas clas);
    void showStudentByTeacher(Teacher teacher);
    void findStudent();

    void addStudent();

    void replaceStudent();

    void removeStudent();

    void addToClas();

}
