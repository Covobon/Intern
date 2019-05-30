package entities;

import java.util.ArrayList;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String email;
    private ArrayList<Clas> clas = new ArrayList<>();

    private static ArrayList<Student> students = new ArrayList<>();

    public Student(String id, String firstName, String lastName, String phonenumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Clas> getClas() {
        return clas;
    }

    public void setClas(ArrayList<Clas> clas) {
        this.clas = clas;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public void addClass(Clas value){
        this.clas.add(value);
    }

    public String showInfo() {
        return "Name: " + this.lastName + "---" + this.lastName + "---Id: " + this.id + "---Email: " + this.email
                +"---Phone Number: " + this.phonenumber;
    }
}
