package entities;

import java.util.ArrayList;

public class Clas {
    String id;

    public Clas(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClas(ArrayList<Clas> clas) {
        this.clas = clas;
    }

    String name;
    ArrayList<Student> students = new ArrayList<>();
    Teacher teacher;

    ArrayList<Clas> clas = new ArrayList<>();

    public Clas(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Clas> getClas() {
        return clas;
    }

}
