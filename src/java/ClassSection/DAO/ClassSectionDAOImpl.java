/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassSection.DAO;

import ClassSection.Bean.ClassSectionBean;
import Classes.Bean.ClassBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public class ClassSectionDAOImpl implements ClassSectionDAO {

    @Override
    public int addClassSection(ClassSectionBean classSectionBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("INSERT INTO class_section (CLASS_ID, SECTION_ID) VALUE(?,?)");
            pre.setInt(1, classSectionBean.getCLASS_ID());
            pre.setInt(2, classSectionBean.getSECTION_ID()); 

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
    public ArrayList getClassSections() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<ClassSectionBean> classSectionBeanList = new ArrayList<>();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM class_section ORDER BY CLASS_SECTION_ID GROUP BY CLASS_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                ClassSectionBean classSectionBean = new ClassSectionBean();
                classSectionBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classSectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));

                classSectionBeanList.add(classSectionBean);
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
        return classSectionBeanList;
    }

}
