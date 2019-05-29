package entities;

import java.util.ArrayList;

public class Teacher {
    private String account;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Clas> clas = new ArrayList<>();

    private static ArrayList<Teacher> teachers = new ArrayList<>();

    public Teacher(String account, String firstName, String lastName, String email) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }
}
