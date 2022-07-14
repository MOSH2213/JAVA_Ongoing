package p_03;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDbUtill {

    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static boolean validate(String useremail, String password) {

        boolean isSucess = true;

        try {
            con = DbConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE useremail='" + useremail + "' AND password='" + password + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                isSucess = true;
            } else {
                isSucess = false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return isSucess;
    }

    public static List<Customer> getCustomer(String email) {
        ArrayList<Customer> customer = new ArrayList<>();
    
        try {
            con = DbConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE useremail='" + email + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String useremail = rs.getString(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                int phone = rs.getInt(4);
                int address = rs.getInt(5);
                String image = rs.getString(6);
                
                Customer cus = new Customer(useremail, password, username, phone, address, image);
                customer.add(cus);
            }

        } catch (Exception e) {
            //TODO: handle exception
        	e.printStackTrace();
        }
        return customer;
    }
}
