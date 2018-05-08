/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassSection.DAO;

import ClassSection.Bean.ClassSectionBean;
import Classes.Bean.ClassBean;
import Section.Bean.SectionBean;
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
            pre = con.prepareStatement("SELECT * FROM class_section as cs\n"
                    + "inner join classes as class on cs.CLASS_ID = class.CLASS_ID\n"
                    + "inner join section as sec on cs.SECTION_ID = sec.SECTION_ID\n"
                    + "ORDER BY CLASS_SECTION_ID");

            rs = pre.executeQuery();
            while (rs.next()) {
                ClassSectionBean classSectionBean = new ClassSectionBean();
                classSectionBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classSectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));

                ClassBean classBean = new ClassBean();
                classBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classBean.setCLASS_NAME(rs.getString("CLASS_NAME"));
                classSectionBean.setClassBean(classBean);

                SectionBean sectionBean = new SectionBean();
                sectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                sectionBean.setSECTION_NAME(rs.getString("SECTION_NAME"));
                classSectionBean.setSectionBean(sectionBean);

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

    @Override
    public ArrayList getSectionsByClassId(int CLASS_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<ClassSectionBean> classSectionBeanList = new ArrayList<>();

        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM class_section as cs\n"
                    + "inner join section as sec on cs.SECTION_ID = sec.SECTION_ID\n"
                    + "WHERE cs.CLASS_ID = ? ORDER BY cs.SECTION_ID");
            pre.setInt(1, CLASS_ID);

            rs = pre.executeQuery();
            while (rs.next()) {
                ClassSectionBean classSectionBean = new ClassSectionBean();
                classSectionBean.setCLASS_SECTION_ID(rs.getInt("CLASS_SECTION_ID"));
                classSectionBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classSectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                
                SectionBean sectionBean = new SectionBean();
                sectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                sectionBean.setSECTION_NAME(rs.getString("SECTION_NAME"));
                classSectionBean.setSectionBean(sectionBean);

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
