package dao;

import entities.Clas;
import entities.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcClasDao implements ClasDao , InitializingBean {
    private DataSource dataSource;
    private PreparedStatement st;
    private Connection conn;
    private JdbcStudentDao jdbcStudentDao;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJdbcStudentDao(JdbcStudentDao jdbcStudentDao) {
        this.jdbcStudentDao = jdbcStudentDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanInitializationException("You must set DataSource on JdbcStudentDao");
        } else {
            conn = dataSource.getConnection();
        }
    }

    @Override
    public ArrayList<Student> getAllStudents(Clas clas) {
        ArrayList<Student> students = new ArrayList<>();
        try{
            String query = "select id_student, first_name, last_name, phonenumber, email from student " +
                    "join joined on student.id_student = joined.id_student " +
                    "where joined.id_class = ? ";
            st = conn.prepareStatement(query);
            st.setString(1, clas.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                students.add(new Student(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void addStudent(Clas clas, Student student) {
        jdbcStudentDao.addStudent(student);
        try {
            String query = "insert into joined(id_student, id_class) value (?, ?)";
            st = conn.prepareStatement(query);
            st.setString(1, student.getId());
            st.setString(2, clas.getId());
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
