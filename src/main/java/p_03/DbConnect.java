package p_03;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    private static String url = "jdbc:mysql://localhost:3306/weena_nadha";
    private static String user="root";
    private static String password = "#True12345";
    private static Connection con;


    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return con;
     }
}
