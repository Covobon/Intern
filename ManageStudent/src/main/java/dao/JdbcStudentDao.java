package dao;

import entities.Clas;
import entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import entities.Student;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcStudentDao implements StudentDao, InitializingBean {
    private DataSource dataSource;
    private PreparedStatement st;
    private Connection conn;

    private static final Logger LOGGER =
            LogManager.getLogger(JdbcStudentDao.class.getName());

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanInitializationException("You must set DataSource on JdbcStudentDao");
        }
        else {
            conn = dataSource.getConnection();
        }

    }

    @Override
    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            String query = "select * from student;";
            st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            students = getStudents(rs);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public ArrayList<Student> getStudentsByTeacher(Teacher teacher) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String query = "select * from student join joined j on student.id_student = j.id_student " +
                    "join class c on j.id_class = c.id_class " +
                    "where c.id_teacher = ?";
            st = conn.prepareStatement(query);
            st.setString(1, teacher.getAccount());
            ResultSet rs = st.executeQuery();
            students = getStudents(rs);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public ArrayList<Student> findStudentsByFirstName(String firstName) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String query = "select * from student where first_name=?;";
            st = conn.prepareStatement(query);
            st.setString(1, firstName);
            ResultSet rs = st.executeQuery();
            students = getStudents(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return students;
    }

    @Override
    public ArrayList<Student> findStudentsByLastName(String lastName) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String query = "select * from student where last_name=?;";
            st = conn.prepareStatement(query);
            st.setString(1, lastName);
            ResultSet rs = st.executeQuery();
            students = getStudents(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return students;
    }

    @Override
    public Student findStudentByPhoneNumber(String phoneNumber) {
        try {
            String query = "select * from student where phonenumber=?;";
            st = conn.prepareStatement(query);
            st.setString(1, phoneNumber);
            ResultSet rs = st.executeQuery();
            return getStudent(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Student findStudentByEmail(String email) {
        try {
            String query = "select * from student where email=?;";
            st = conn.prepareStatement(query);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            return getStudent(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Student findStudentById(String id) {
        try {
            String query = "select * from student where id_student=?;";
            st = conn.prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            return getStudent(rs);

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public ArrayList<Student> findStudentsByValue(String info) {
        try {
            String query = "select * from student where id_student like ? or " +
                    "last_name like ? or first_name like ? or email like ? or phonenumber like ?";
            st = conn.prepareStatement(query);
            st.setString(1, '%' + info + '%');
            st.setString(2, '%' + info + '%');
            st.setString(3, '%' + info + '%');
            st.setString(4, '%' + info + '%');
            st.setString(5, '%' + info + '%');
            ResultSet rs = st.executeQuery();
            return getStudents(rs);

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        try {
            String query = "select count(*) from student where id_student=? or email=? or phonenumber=?";
            st = conn.prepareStatement(query);
            st.setString(1, student.getId());
            st.setString(2, student.getEmail());
            st.setString(3, student.getPhonenumber());
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0){
                String query1 = "insert into student(id_student, first_name, last_name, email, phonenumber) VALUE (?, ?, ?, ? , ?)";
                st = conn.prepareStatement(query1);
                st.setString(1, student.getId());
                st.setString(2, student.getFirstName());
                st.setString(3, student.getLastName());
                st.setString(4, student.getEmail());
                st.setString(5, student.getPhonenumber());
                st.executeUpdate();
            }
            else{
                throw new SQLException("Data is exists");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void replaceStudent(Student student) {
        try {
            String query2 = "update student " +
                    "set first_name = ? , last_name = ?, email = ? , phonenumber = ? " +
                    "where id_student = ?;";
            st = conn.prepareStatement(query2);
            st.setString(5, student.getId());
            st.setString(1, student.getFirstName());
            st.setString(2, student.getLastName());
            st.setString(3, student.getEmail());
            st.setString(4, student.getPhonenumber());
            st.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeStudent(String value) {
        try {
            String query = "delete from student where id_student = ? or email = ? or phonenumber = ? ";
            st = conn.prepareStatement(query);
            st.setString(1, value);
            st.setString(2, value);
            st.setString(3, value);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setClass(String value){
        try {
            String query = "";
            st = conn.prepareStatement(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addToClas(Student student, Clas clas) {
        try {
            st = conn.prepareStatement("select count(*) from student where id_student = ?");
            st.setString(1, student.getId());
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0){
                System.out.println("Student you choose does not exists");
                return;
            }
            st = conn.prepareStatement("select count(*) from class where id_class = ?");
            rs = st.executeQuery();
            rs.next();
            if(rs.getInt(1) == 0) {
                System.out.println("Class you choose does not exists");
                return;
            }
            String query = "insert into joined(id_student, id_class) VALUE (?, ?)";
            st = conn.prepareStatement(query);

            st.setString(1, student.getId());
            st.setString(2, clas.getId());
            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    private ArrayList<Student> getStudents(ResultSet rs) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        while(rs.next()) {
            students.add(new Student(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(6), rs.getString(5)));
        }
        return students;
    }

    private Student getStudent(ResultSet rs) throws SQLException {
        rs.next();
        return new Student(rs.getString(1), rs.getString(2),
                rs.getString(3), rs.getString(6), rs.getString(5));
    }
}
