

package services;

import entities.Clas;
import entities.Student;

import java.util.ArrayList;

public interface ServiceStudent {
    void removeClass(Student student, Clas clas);
    void addClass(Student student, Clas clas);
}
