import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
            conn = DriverManager.getConnection("jdbc://localhost:3306/managestudent","root","123456");
            //m?c dinh là c?ng 3306 nên có th? b? :3306

            if(conn!=null)
            {
                System.out.println("Sucessfull");
            }


        }
        catch(Exception e)
        {e.printStackTrace();
            /*System.out.println("Do not connect to DB - Error:"+e);*/

        }finally {
            try {
                if (preparedStatement!=null)
                {
                    preparedStatement.close();
                }
                if (conn!=null)
                {
                    conn.close();
                }
            }catch (Exception e)
            {
                System.out.println("Erro close connect to database");
            }
        }
    }
}
