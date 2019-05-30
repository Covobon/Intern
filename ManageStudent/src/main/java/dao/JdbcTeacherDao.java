package dao;

import entities.Clas;
import entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcTeacherDao implements TeacherDao, InitializingBean {
    private DataSource dataSource;
    private JdbcClasDao jdbcClasDao;
    Connection conn;

    public void setJdbcClasDao(JdbcClasDao jdbcClasDao) {
        this.jdbcClasDao = jdbcClasDao;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setSt(PreparedStatement st) {
        this.st = st;
    }

    PreparedStatement st;

    private static final Logger LOGGER =
            LogManager.getLogger(JdbcStudentDao.class.getName());

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if(this.dataSource == null)
            throw new BeanInitializationException("You must set DataSource on JdbcTeacherDao");
        conn = dataSource.getConnection();
    }

    @Override
    public Teacher loggin(String account, String firstName, String lastName, String email)  {
        Teacher teacher = null  ;
        boolean checkExists = false;
        String query = "select count(*) as total from teacher where id_teacher=?;";
        try {
            st = conn.prepareStatement(query);
            st.setString(1, account);
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                String query1 = "insert into teacher(id_teacher, first_name, last_name, email) VALUE (?,?,?,?)";
                st = conn.prepareStatement(query1);

                st.setString(1, account);
                st.setString(2, firstName);
                st.setString(3, lastName);
                st.setString(4, email);
                st.executeUpdate();
                LOGGER.info("Logined");
            } else {
                String query2 = "update teacher " +
                        "set first_name = ?, last_name = ?, email = ? " +
                        "where id_teacher = ?;";
                st = conn.prepareStatement(query2);
                st.setString(1, firstName);
                st.setString(2, lastName);
                st.setString(3, email);
                st.setString(4, account);
                st.executeUpdate();
                LOGGER.info("Updated");
            }
            return new Teacher(account, firstName, lastName, email);
        }catch (SQLException e){
            System.out.println("ERROR: Email is exists in database, email must is unique");
        }
        return teacher;
    }

    @Override
    public void getClas(Teacher teacher, Clas clas) {
        try {
            String query="select * from class where id_class = ?";
            st = conn.prepareStatement(query);
            st.setString(1, clas.getId());
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0){
                jdbcClasDao.openClas(clas, teacher);
            }
            else {
                String query1 = "update class set id_teacher = ? where id_class = ?";
                st = conn.prepareStatement(query1);
                st.setString(1, teacher.getAccount());
                st.setString(2, clas.getId());
                st.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
