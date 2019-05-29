package dao;

import entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;

public class JdbcTeacherDao implements TeacherDao, InitializingBean {
    private DataSource dataSource;
    Connection conn;
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
    public Teacher loggin(String account, String firstName, String lastName, String email) {
        Teacher teacher = null  ;
        boolean checkExists = false;
        String query = "select count(*) as total from teacher where id_teacher=?;";
        try {
            st = conn.prepareStatement(query);
            st.setString(1, account);
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0){
                String query1 = "insert into teacher(id_teacher, first_name, last_name, email) VALUE (?,?,?,?)";
                st = conn.prepareStatement(query1);

                st.setString(1, account);
                st.setString(2, firstName);
                st.setString(3,lastName);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }
}
