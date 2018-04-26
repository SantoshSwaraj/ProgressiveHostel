/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Section.DAO;

import Section.Bean.SectionBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mishra
 */
public class SectionDAOImpl implements SectionDAO {

    @Override
    public int addSection(SectionBean sectionBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("INSERT INTO section (SECTION_NAME) VALUE (?)");

            pre.setString(1, sectionBean.getSECTION_NAME());
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
    public ArrayList getSections() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<SectionBean> sectionBeanList = new ArrayList<>();

        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM section ORDER BY SECTION_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                SectionBean sectionBean = new SectionBean();
                sectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                sectionBean.setSECTION_NAME(rs.getString("SECTION_NAME"));

                sectionBeanList.add(sectionBean);
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
        return sectionBeanList;

    }

    @Override
    public SectionBean getSectionById(int SECTION_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        SectionBean sectionBean = new SectionBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM section WHERE SECTION_ID = ?");
            pre.setInt(1, SECTION_ID);

            rs = pre.executeQuery();
            if (rs.next()) {
                sectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                sectionBean.setSECTION_NAME(rs.getString("SECTION_NAME"));
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
        return sectionBean;
    }

}
