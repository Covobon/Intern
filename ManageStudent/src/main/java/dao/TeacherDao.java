package dao;

import entities.Teacher;

public interface TeacherDao {
    Teacher loggin(String account, String firstName, String lastName, String email);
}
