/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentParentDetails.DAO;

import StudentParentDetails.Bean.StudentParentDetailsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentParentDetailsDAOImpl implements StudentParentDetailsDAO {

    @Override
    public int addStudentParentDetails(StudentParentDetailsBean studentParentDetailsBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("UPDATE student_parent_details SET STUDENT_FATHER_NAME = ?, STUDENT_FATHER_MOBILE_NUMBER = ?, STUDENT_FATHER_OCCUPATION = ?,\n"
                    + "STUDENT_MOTHER_NAME = ?, STUDENT_MOTHER_MOBILE_NUMBER =?, STUDENT_MOTHER_OCCUPATION = ?, STUDENT_GUARDIAN_NAME = ?, STUDENT_GUARDIAN_MOBILE = ?, ENTRY_ID = ? WHERE STUDENT_ID =?");
            pre.setString(1, studentParentDetailsBean.getSTUDENT_FATHER_NAME());
            pre.setString(2, studentParentDetailsBean.getSTUDENT_FATHER_MOBILE_NUMBER());
            pre.setString(3, studentParentDetailsBean.getSTUDENT_FATHER_OCCUPATION());
            pre.setString(4, studentParentDetailsBean.getSTUDENT_MOTHER_NAME());
            pre.setString(5, studentParentDetailsBean.getSTUDENT_MOTHER_MOBILE_NUMBER());
            pre.setString(6, studentParentDetailsBean.getSTUDENT_MOTHER_OCCUPATION());
            pre.setString(7, studentParentDetailsBean.getSTUDENT_GUARDIAN_NAME());
            pre.setString(8, studentParentDetailsBean.getSTUDENT_GUARDIAN_MOBILE());
            pre.setInt(9, studentParentDetailsBean.getENTRY_ID());
            pre.setInt(10, studentParentDetailsBean.getSTUDENT_ID());

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
    public ArrayList getAllStudentParentDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
