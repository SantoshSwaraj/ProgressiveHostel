/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Month.DAO;

import Classes.Bean.ClassBean;
import Month.Bean.MonthBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public class MonthDAOImpl implements MonthDAO {

    @Override
    public ArrayList getMonths() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<MonthBean> monthBeanList = new ArrayList<>();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM month ORDER BY MONTH_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                MonthBean monthBean = new MonthBean();
                monthBean.setMONTH_ID(rs.getInt("MONTH_ID"));
                monthBean.setMONTH(rs.getString("MONTH"));

                monthBeanList.add(monthBean);
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
        return monthBeanList;
    }

    @Override
    public MonthBean getMonthById(int MONTH_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        MonthBean monthBean = new MonthBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM month WHERE MONTH_ID = ?");

            pre.setInt(1, MONTH_ID);
            rs = pre.executeQuery();

            if (rs.next()) {
                monthBean.setMONTH_ID(rs.getInt("MONTH_ID"));
                monthBean.setMONTH(rs.getString("MONTH"));
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
        return monthBean;
    }

}
