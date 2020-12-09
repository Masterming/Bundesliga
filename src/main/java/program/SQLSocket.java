package program;

import java.sql.*;
import java.util.*;

/**
 * @author Rene
 */
public class SQLSocket {

    private Connection con;

    public SQLSocket() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MYSQL-Driver not found");
            return;
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "");
            //System.out.println("connected to sqlsocket");
        } catch (SQLException e) {
            System.out.println("connection to sqlsocket failed:" + e.getMessage());
        }
    }
    
    public List<String> getAllPlayers() {
        List<String> l = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Name from Players");
            while (rs.next()) {
                l.add(rs.getString(1));
            }
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
        return l;
    }
}
