/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseConnection;

import java.sql.DriverManager;

/**
 *
 * @author Santosh Kushwaha
 */
public class Connection {

    public static java.sql.Connection con() {
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/progressive_hostel", "root", "root");
            System.out.println("DataBase connected");
        } catch (Exception e) {
            System.out.println("DataBase Not Connected");
        }
        return con;
    }
}
