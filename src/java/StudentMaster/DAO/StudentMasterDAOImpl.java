/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMaster.DAO;

import Session.Bean.SessionBean;
import Session.DAO.SessionDAO;
import Session.DAO.SessionDAOImpl;
import StudentAddressDetails.Bean.StudentAddressDetailsBean;
import StudentDocumentDetails.Bean.StudentDocumentDetailsBean;
import StudentMaster.Bean.StudentMasterBean;
import StudentMaster.DAO.StudentMasterDAO;
import StudentOneTimeChargeDetails.Bean.StudentOneTimeChargeDetailsBean;
import StudentParentDetails.Bean.StudentParentDetailsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentMasterDAOImpl implements StudentMasterDAO {

    @Override
    public int addStudentMaster(StudentMasterBean studentMasterBean) {
        Connection con = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;
        PreparedStatement pre3 = null;
        PreparedStatement pre4 = null;
        PreparedStatement pre5 = null;

        ResultSet rs = null;
        //int i = 0;
        int generatedStudentId = 0;
        try {
            con = DataBaseConnection.Connection.con();

            con.setAutoCommit(false);
            con.rollback();

            //Add Student Master Query to Batch Starts
            pre1 = con.prepareStatement("INSERT INTO student_master (STUDENT_NAME, SESSION_ID, CLASS_ID, SECTION_ID, STUDENT_ROLL_NO, \n"
                    + "STUDENT_DOB, ADMISSION_NO, IS_ACTIVE, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME) VALUE (?,?,?,?,?,?,?,?,?,CURDATE(),NOW())",
                    Statement.RETURN_GENERATED_KEYS);
            pre1.setString(1, studentMasterBean.getSTUDENT_NAME());
            pre1.setInt(2, studentMasterBean.getSESSION_ID());
            pre1.setInt(3, studentMasterBean.getCLASS_ID());
            pre1.setInt(4, studentMasterBean.getSECTION_ID());
            pre1.setInt(5, studentMasterBean.getSTUDENT_ROLL_NO());
            pre1.setDate(6, studentMasterBean.getSTUDENT_DOB());
            pre1.setString(7, studentMasterBean.getADMISSION_NO());
            pre1.setInt(8, studentMasterBean.getIS_ACTIVE());
            pre1.setInt(9, studentMasterBean.getENTRY_ID());

            pre1.addBatch();
            int[] stuMater = pre1.executeBatch();
            rs = pre1.getGeneratedKeys();
            if (rs.next()) {
                generatedStudentId = rs.getInt(1);
            }
            //Add Student Master Query to Batch Ends

            // Add Parents Blank Detail Query to Batch Starts
            pre2 = con.prepareStatement("INSERT INTO student_parent_details (STUDENT_ID, STUDENT_FATHER_NAME, STUDENT_FATHER_MOBILE_NUMBER, STUDENT_FATHER_OCCUPATION,\n"
                    + "STUDENT_MOTHER_NAME, STUDENT_MOTHER_MOBILE_NUMBER, STUDENT_MOTHER_OCCUPATION, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME) VALUE (\n"
                    + "?,?,?,?,?,?,?,?,CURDATE(), NOW())");

            pre2.setInt(1, generatedStudentId);
            pre2.setString(2, "");
            pre2.setString(3, "");
            pre2.setString(4, "");
            pre2.setString(5, "");
            pre2.setString(6, "");
            pre2.setString(7, "");
            pre2.setInt(8, studentMasterBean.getENTRY_ID());
            pre2.addBatch();
            int[] stuParent = pre2.executeBatch();
            // Add Parents Blank Detail Query to Batch Ends

            // Add Address Blank Details Query to Batch Starts
            pre3 = con.prepareStatement("INSERT INTO student_address_details (STUDENT_ID, STUDENT_C_ADDRESS, STUDENT_C_STATE, STUDENT_C_CITY, STUDENT_C_PIN_CODE,\n"
                    + "STUDENT_P_ADDRESS, STUDENT_P_STATE, STUDENT_P_CITY, STUDENT_P_PIN_CODE, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME) VALUE (\n"
                    + "?,?,?,?,?,?,?,?,?,?,CURDATE(), NOW())");
            pre3.setInt(1, generatedStudentId);
            pre3.setString(2, "");
            pre3.setString(3, "");
            pre3.setString(4, "");
            pre3.setString(5, "");
            pre3.setString(6, "");
            pre3.setString(7, "");
            pre3.setString(8, "");
            pre3.setString(9, "");
            pre3.setInt(10, studentMasterBean.getENTRY_ID());
            pre3.addBatch();
            int[] stuAddress = pre3.executeBatch();
            // Add Address Blank Details Query to Batch Ends

            // Add Documents Blank Details Query to Batch Starts
            pre4 = con.prepareStatement("INSERT INTO student_document_details (STUDENT_ID, STUDENT_PHOTO_DOC, STUDENT_AADHAR_DOC, \n"
                    + "STUDENT_SCHOOL_ID_DOC, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME) VALUE (?,?,?,?,?,CURDATE(),NOW())");
            pre4.setInt(1, generatedStudentId);
            pre4.setString(2, "");
            pre4.setString(3, "");
            pre4.setString(4, "");
            pre4.setInt(5, studentMasterBean.getENTRY_ID());
            pre4.addBatch();
            int[] stuDocument = pre4.executeBatch();
            // Add Documents Blank Details Query to Batch Ends

            // Add OneTimeCharges Blank Details Query to Batch Starts
            pre5 = con.prepareStatement("INSERT INTO student_one_time_charge_details (STUDENT_ID, SECURITY_MONEY, PACKET_MONEY,\n"
                    + "TOTAL_TO_PAY, TOTAL_PAID_AMT, BALANCE_AMT, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME) value\n"
                    + "(?,?,?,?,?,?,?,CURDATE(), NOW())");

            pre5.setInt(1, generatedStudentId);
            pre5.setInt(2, 0);
            pre5.setInt(3, 0);
            pre5.setInt(4, 0);
            pre5.setInt(5, 0);
            pre5.setInt(6, 0);
            pre5.setInt(7, studentMasterBean.getENTRY_ID());
            pre5.addBatch();
            int[] stuOneTimeCharge = pre5.executeBatch();
            // Add OneTimeCharges Blank Details Query to Batch Ends

            if (stuMater.length == 1 && stuParent.length == 1 && stuAddress.length == 1 && stuDocument.length == 1 && stuOneTimeCharge.length == 1) {
                con.commit();

            } else {
                con.rollback();
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pre1 != null) {
                    pre1.close();
                }
                if (pre2 != null) {
                    pre2.close();
                }
                if (pre3 != null) {
                    pre3.close();
                }
                if (pre4 != null) {
                    pre4.close();
                }
                if (pre5 != null) {
                    pre5.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return generatedStudentId;
    }

    @Override
    public ArrayList getAllStudentMasterDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentMasterBean getStudentAllDetailsById(int STUDENT_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        StudentMasterBean studentMasterBean = new StudentMasterBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM student_master as sm\n"
                    + "LEFT JOIN student_parent_details as spd\n"
                    + "ON sm.STUDENT_ID = spd.STUDENT_ID\n"
                    + "LEFT JOIN student_address_details as sad\n"
                    + "ON sm.STUDENT_ID = sad.STUDENT_ID \n"
                    + "LEFT JOIN student_one_time_charge_details as scd\n"
                    + "ON sm.STUDENT_ID = scd.STUDENT_ID\n"
                    + "WHERE sm.STUDENT_ID = ?");

            pre.setInt(1, STUDENT_ID);
            rs = pre.executeQuery();
            if (rs.next()) {
                StudentParentDetailsBean studentParentDetailsBean = new StudentParentDetailsBean();
                StudentAddressDetailsBean studentAddressDetailsBean = new StudentAddressDetailsBean();
                //StudentDocumentDetailsBean studentDocumentDetailsBean = new StudentDocumentDetailsBean();
                StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean = new StudentOneTimeChargeDetailsBean();

                /*==========================Setting Student Master Details Starts===============================*/
                studentMasterBean.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                studentMasterBean.setSTUDENT_NAME(rs.getString("STUDENT_NAME"));
                studentMasterBean.setSESSION_ID(rs.getInt("SESSION_ID"));
                studentMasterBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                studentMasterBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                studentMasterBean.setSTUDENT_ROLL_NO(rs.getInt("STUDENT_ROLL_NO"));
                studentMasterBean.setSTUDENT_DOB(rs.getDate("STUDENT_DOB"));
                studentMasterBean.setADMISSION_NO(rs.getString("ADMISSION_NO"));
                studentMasterBean.setENTRY_ID(rs.getInt("ENTRY_ID"));
                studentMasterBean.setENTRY_DATE(rs.getDate("ENTRY_DATE"));
                /*==========================Setting Student Master Details Ends===============================*/

                /*==========================Setting Student Parents Details Starts===========================*/
                studentParentDetailsBean.setSTUDENT_FATHER_NAME(rs.getString("STUDENT_FATHER_NAME"));
                studentParentDetailsBean.setSTUDENT_FATHER_MOBILE_NUMBER(rs.getString("STUDENT_FATHER_MOBILE_NUMBER"));
                studentParentDetailsBean.setSTUDENT_FATHER_OCCUPATION(rs.getString("STUDENT_FATHER_OCCUPATION"));
                studentParentDetailsBean.setSTUDENT_MOTHER_NAME(rs.getString("STUDENT_MOTHER_NAME"));
                studentParentDetailsBean.setSTUDENT_MOTHER_MOBILE_NUMBER(rs.getString("STUDENT_MOTHER_MOBILE_NUMBER"));
                studentParentDetailsBean.setSTUDENT_MOTHER_OCCUPATION(rs.getString("STUDENT_MOTHER_OCCUPATION"));
                /*==========================Setting Student Master Details Ends==========================*/

                /*==========================Setting Student Address Details Starts===========================*/
                studentAddressDetailsBean.setSTUDENT_C_ADDRESS(rs.getString("STUDENT_C_ADDRESS"));
                studentAddressDetailsBean.setSTUDENT_C_STATE(rs.getString("STUDENT_C_STATE"));
                studentAddressDetailsBean.setSTUDENT_C_CITY(rs.getString("STUDENT_C_CITY"));
                studentAddressDetailsBean.setSTUDENT_C_PIN_CODE(rs.getString("STUDENT_C_PIN_CODE"));
                studentAddressDetailsBean.setSTUDENT_P_ADDRESS(rs.getString("STUDENT_P_ADDRESS"));
                studentAddressDetailsBean.setSTUDENT_P_STATE(rs.getString("STUDENT_P_STATE"));
                studentAddressDetailsBean.setSTUDENT_P_CITY(rs.getString("STUDENT_P_CITY"));
                studentAddressDetailsBean.setSTUDENT_P_PIN_CODE(rs.getString("STUDENT_P_PIN_CODE"));
                /*==========================Setting Student Address Details Ends===========================*/

                /*==========================Setting Student One Time Charge Details Starts===========================*/
                studentOneTimeChargeDetailsBean.setSECURITY_MONEY(rs.getInt("SECURITY_MONEY"));
                studentOneTimeChargeDetailsBean.setPACKET_MONEY(rs.getInt("PACKET_MONEY"));
                studentOneTimeChargeDetailsBean.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                studentOneTimeChargeDetailsBean.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                studentOneTimeChargeDetailsBean.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                /*==========================Setting Student One Time Charge Details Ends===========================*/

                studentMasterBean.setStudentParentDetailsBean(studentParentDetailsBean);
                studentMasterBean.setStudentAddressDetailsBean(studentAddressDetailsBean);
                studentMasterBean.setStudentOneTimeChargeDetailsBean(studentOneTimeChargeDetailsBean);
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
        return studentMasterBean;
    }

    @Override
    public String generateAdmissionNo(SessionBean sessionBean) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String[] sessArray = sessionBean.getSESSION().split("-");
        String sess = sessArray[0];
        String admNo = "0001-" + sess;
        try {
            con = DataBaseConnection.Connection.con();
            
            pre = con.prepareStatement("SELECT max(ADMISSION_NO) as ADM_NO from student_master WHERE SESSION_ID = ?");
            pre.setInt(1, sessionBean.getSESSION_ID());
            rs = pre.executeQuery();

            if (rs.next()) {
                String ap = rs.getString("ADM_NO");
                String[] s = ap.split("-");
                int a = Integer.parseInt(s[0]) + 1;
                String str = "" + a;
                if (str.length() == 1) {
                    s[0] = "000" + str;
                }
                if (str.length() == 2) {
                    s[0] = "00" + str;
                }
                if (str.length() == 3) {
                    s[0] = "0" + str;
                }
                if (str.length() == 4) {
                    s[0] = str;
                }
                admNo = s[0] + "-" + Integer.parseInt(s[1]);

            } else {
                admNo = "0001-" + sess;
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
        return admNo;
    }

}
