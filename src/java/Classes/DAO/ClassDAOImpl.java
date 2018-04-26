/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DAO;

import Classes.Bean.ClassBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public class ClassDAOImpl implements ClassDAO {

    @Override
    public int addClass(ClassBean classBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("INSERT INTO classes (CLASS_NAME) VALUE(?)");
            pre.setString(1, classBean.getCLASS_NAME());

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

    @Override
    public ArrayList getClasses() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<ClassBean> classBeanList = new ArrayList<>();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM classes ORDER BY CLASS_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                ClassBean classBean = new ClassBean();
                classBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classBean.setCLASS_NAME(rs.getString("CLASS_NAME"));

                classBeanList.add(classBean);
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
        return classBeanList;
    }

    @Override
    public ClassBean getClassById(int CLASS_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ClassBean classBean = new ClassBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM classes WHERE CLASS_ID = ?");

            pre.setInt(1, CLASS_ID);
            rs = pre.executeQuery();

            if (rs.next()) {
                classBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classBean.setCLASS_NAME(rs.getString("CLASS_NAME"));
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
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return classBean;
    }

}
