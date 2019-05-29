//TODO

package services;

import entities.Clas;
import entities.Student;

import java.util.ArrayList;

public class ServiceStudentImpl implements ServiceStudent{


    @Override
    public void removeClass(Student student, Clas clas) {
        ArrayList<Clas> clases = student.getClas();
        for (int i = 0; i < clases.size(); i++){
            if (clases.get(i).getId() ==  clas.getId())
                clases.remove(i);
        }
    }

    @Override
    public void addClass(Student student, Clas clas) {
        student.getClas().add(clas);
    }
}
