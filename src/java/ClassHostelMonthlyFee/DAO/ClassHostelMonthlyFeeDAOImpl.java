/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassHostelMonthlyFee.DAO;

import ClassHostelMonthlyFee.Bean.ClassHostelMonthlyFeeBean;
import ClassSection.Bean.ClassSectionBean;
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
public class ClassHostelMonthlyFeeDAOImpl implements ClassHostelMonthlyFeeDAO {

    @Override
    public int addClassHostelMonthlyFee(ClassHostelMonthlyFeeBean classHostelMonthlyFeeBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("INSERT INTO class_hostel_monthly_fee (CLASS_ID, FEE) VALUE(?,?)");
            pre.setInt(1, classHostelMonthlyFeeBean.getCLASS_ID());
            pre.setInt(2, classHostelMonthlyFeeBean.getFEE());

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
    public ArrayList getClassHostelMonthlyFees() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<ClassHostelMonthlyFeeBean> classHostelMonthlyFeeBeanList = new ArrayList<>();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM class_hostel_monthly_fee chmf\n"
                    + "inner join classes as class on chmf.CLASS_ID = class.CLASS_ID\n"
                    + "ORDER BY CLASS_HOSTEL_MONTHLY_FEE_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                ClassHostelMonthlyFeeBean classHostelMonthlyFeeBean = new ClassHostelMonthlyFeeBean();
                classHostelMonthlyFeeBean.setCLASS_HOSTEL_MONTHLY_FEE_ID(rs.getInt("CLASS_HOSTEL_MONTHLY_FEE_ID"));
                classHostelMonthlyFeeBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classHostelMonthlyFeeBean.setFEE(rs.getInt("FEE"));

                ClassBean classBean = new ClassBean();
                classBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classBean.setCLASS_NAME(rs.getString("CLASS_NAME"));
                classHostelMonthlyFeeBean.setClassBean(classBean);

                classHostelMonthlyFeeBeanList.add(classHostelMonthlyFeeBean);
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
        return classHostelMonthlyFeeBeanList;
    }

    @Override
    public ClassHostelMonthlyFeeBean getClassHostelMonthlyFeeByClassId(int CLASS_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ClassHostelMonthlyFeeBean classHostelMonthlyFeeBean = new ClassHostelMonthlyFeeBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM class_hostel_monthly_fee WHERE CLASS_ID = ?");

            pre.setInt(1, CLASS_ID);
            rs = pre.executeQuery();

            if (rs.next()) {

                classHostelMonthlyFeeBean.setCLASS_HOSTEL_MONTHLY_FEE_ID(rs.getInt("CLASS_HOSTEL_MONTHLY_FEE_ID"));
                classHostelMonthlyFeeBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classHostelMonthlyFeeBean.setFEE(rs.getInt("FEE"));
            }

        } catch (SQLException e) {
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
        return classHostelMonthlyFeeBean;
    }

}
