/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OneTimeCharges.DAO;

import Classes.Bean.ClassBean;
import OneTimeCharges.Bean.OneTimeChargeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Santosh
 */
public class OneTimeChargesDAOImpl implements OneTimeChargesDAO {

    @Override
    public int addOneTimeCharges(OneTimeChargeBean oneTimeChargeBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("INSERT INTO one_time_charges (CHARGE_NAME, CHARGE_AMOUNT) VALUE(?,?)");
            pre.setString(1, oneTimeChargeBean.getCHARGE_NAME());
            pre.setInt(2, oneTimeChargeBean.getCHARGE_AMOUNT());

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
    public ArrayList getOneTimeCharges() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<OneTimeChargeBean> oneTimeChargeBeanList = new ArrayList<>();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM one_time_charges ORDER BY ONE_TIME_CHARGE_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                OneTimeChargeBean oneTimeChargeBean = new OneTimeChargeBean();
                oneTimeChargeBean.setONE_TIME_CHARGE_ID(rs.getInt("ONE_TIME_CHARGE_ID"));
                oneTimeChargeBean.setCHARGE_NAME(rs.getString("CHARGE_NAME"));
                oneTimeChargeBean.setCHARGE_AMOUNT(rs.getInt("CHARGE_AMOUNT"));

                oneTimeChargeBeanList.add(oneTimeChargeBean);
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
        return oneTimeChargeBeanList;
    }

}
