/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santosh
 */
public class Query {
    public static int checkLoginDetails(UserBean userBean){
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int USER_ID = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("select USER_ID from user where USERNAME = ? and PASSWORD = ? and STATUS = 1");
            pre.setString(1, userBean.getUSERNAME());
            pre.setString(2, userBean.getPASSWORD());
            rs = pre.executeQuery();
            if (rs.next()) {
                USER_ID = rs.getInt("USER_ID");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return USER_ID;
    }
    
    public static UserBean viewLoginUserDetails(int USER_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        UserBean userBean = new UserBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("select * from user where USER_ID = ?");
            pre.setInt(1, USER_ID);
            rs = pre.executeQuery();
            if (rs.next()) {
                userBean.setUSER_ID(rs.getInt("USER_ID"));
                userBean.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
                userBean.setEMP_NAME(rs.getString("EMP_NAME"));
                userBean.setMOBILE_NO(rs.getString("MOBILE_NO"));
                userBean.setEMAIL(rs.getString("EMAIL"));
                userBean.setUSERNAME(rs.getString("USERNAME"));
                userBean.setPASSWORD(rs.getString("PASSWORD"));
                userBean.setUSER_TYPE_ID(rs.getInt("USER_TYPE_ID"));
                userBean.setSTATUS(rs.getInt("STATUS"));
                userBean.setENTRY_DATE_TIME(rs.getTimestamp("ENTRY_DATE_TIME"));
            }
        } catch (Exception e) {
             System.out.println(e);
        } finally {
           try {
                if (rs != null) {
                    rs.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return userBean;
    }
}
