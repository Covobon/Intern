import org.springframework.context.support.GenericXmlApplicationContext;

import org.junit.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
public class Run {
    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/drivermanager-cfg-01.xml");
        ctx.refresh();

        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();

    }

    private static void testDataSource(DataSource dataSource) throws Exception{
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("SELECT 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())  {
                int mockVal = resultSet.getInt("1");
                assertTrue(mockVal== 1);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println("Co loi o day");
        }
        connection.close();
    }
}
