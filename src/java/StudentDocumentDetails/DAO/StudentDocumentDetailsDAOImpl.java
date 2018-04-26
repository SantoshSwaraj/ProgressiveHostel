/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentDocumentDetails.DAO;

import StudentDocumentDetails.Bean.StudentDocumentDetailsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentDocumentDetailsDAOImpl implements StudentDocumentDetailsDAO {

    @Override
    public int addStudentDocumentDetails(StudentDocumentDetailsBean studentDocumentDetailsBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("UPDATE student_document_details SET STUDENT_PHOTO_DOC = ?, "
                    + "STUDENT_AADHAR_DOC = ?, STUDENT_SCHOOL_ID_DOC = ?, ENTRY_ID = ?\n"
                    + "WHERE STUDENT_ID = ?");
            pre.setString(1, studentDocumentDetailsBean.getSTUDENT_PHOTO_DOC());
            pre.setString(2, studentDocumentDetailsBean.getSTUDENT_AADHAR_DOC());
            pre.setString(3, studentDocumentDetailsBean.getSTUDENT_SCHOOL_ID_DOC());
            pre.setInt(4, studentDocumentDetailsBean.getENTRY_ID());
            pre.setInt(5, studentDocumentDetailsBean.getSTUDENT_ID());
            
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
