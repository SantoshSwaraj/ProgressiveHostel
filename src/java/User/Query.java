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

    public static int checkLoginDetails(UserBean userBean) {
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

    public static int addUser(UserBean userBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("INSERT INTO user (EMPLOYEE_ID, EMP_NAME, MOBILE_NO, EMAIL, USERNAME, PASSWORD, USER_TYPE_ID, STATUS, ENTRY_DATE_TIME)\n"
                    + "VALUE (?,?,?,?,?,?,?,?, NOW())");

            pre.setInt(1, userBean.getEMPLOYEE_ID());
            pre.setString(2, userBean.getEMP_NAME());
            pre.setString(3, userBean.getMOBILE_NO());
            pre.setString(4, userBean.getEMAIL());
            pre.setString(5, userBean.getUSERNAME());
            pre.setString(6, userBean.getPASSWORD());
            pre.setInt(7, userBean.getUSER_TYPE_ID());
            pre.setInt(8, userBean.getSTATUS());

            i = pre.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
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
        return i;
    }

    public static UserBean searchPasswordByEmail(String EMAIL) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        UserBean userBean = new UserBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT *FROM user WHERE EMAIL = ?");
            pre.setString(1, EMAIL);

            rs = pre.executeQuery();
            while (rs.next()) {
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

    public static UserBean searchPasswordByMobile(String MOBILE) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        UserBean userBean = new UserBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT *FROM user WHERE MOBILE_NO = ?");
            pre.setString(1, MOBILE);

            rs = pre.executeQuery();
            while (rs.next()) {
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

    public static UserBean viewUserRegById(int USER_ID) throws SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        UserBean userBean = new UserBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT *FROM user WHERE USER_ID = ?");
            pre.setInt(1, USER_ID);

            rs = pre.executeQuery();
            while (rs.next()) {
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

    public static int updatePassword(UserBean userBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("Update user set PASSWORD = ? where USER_ID = ?");
            pre.setString(1, userBean.getPASSWORD());
            pre.setInt(2, userBean.getUSER_ID());

            i = pre.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
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
        return i;
    }

}
