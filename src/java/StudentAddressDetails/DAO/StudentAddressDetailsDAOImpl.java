/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentAddressDetails.DAO;

import StudentAddressDetails.Bean.StudentAddressDetailsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentAddressDetailsDAOImpl implements StudentAddressDetailsDAO {

    @Override
    public int addStudentAddressDetails(StudentAddressDetailsBean studentAddressDetailsBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("UPDATE student_address_details SET STUDENT_C_ADDRESS = ?, STUDENT_C_STATE = ?, STUDENT_C_CITY =?, STUDENT_C_PIN_CODE = ?,\n"
                    + "STUDENT_P_ADDRESS = ?, STUDENT_P_STATE = ?, STUDENT_P_CITY = ?, STUDENT_P_PIN_CODE = ?, ENTRY_ID = ? WHERE STUDENT_ID = ?");
            pre.setString(1, studentAddressDetailsBean.getSTUDENT_C_ADDRESS());
            pre.setString(2, studentAddressDetailsBean.getSTUDENT_C_STATE());
            pre.setString(3, studentAddressDetailsBean.getSTUDENT_C_CITY());
            pre.setString(4, studentAddressDetailsBean.getSTUDENT_C_PIN_CODE());
            pre.setString(5, studentAddressDetailsBean.getSTUDENT_P_ADDRESS());
            pre.setString(6, studentAddressDetailsBean.getSTUDENT_P_STATE());
            pre.setString(7, studentAddressDetailsBean.getSTUDENT_P_CITY());
            pre.setString(8, studentAddressDetailsBean.getSTUDENT_P_PIN_CODE());
            pre.setInt(9, studentAddressDetailsBean.getENTRY_ID());
            pre.setInt(10, studentAddressDetailsBean.getSTUDENT_ID());

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
