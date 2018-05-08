/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentOneTimeChargeDetails.DAO;

import HostelMonthlyFeeLedger.Service.HostelMonthlyFeeLedgerService;
import HostelMonthlyFeeLedger.Service.HostelMonthlyFeeLedgerServiceImpl;
import StudentMaster.Bean.StudentMasterBean;
import StudentMaster.DAO.StudentMasterDAO;
import StudentMaster.DAO.StudentMasterDAOImpl;
import StudentOneTimeChargeDetails.Bean.StudentOneTimeChargeDetailsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentOneTimeChargeDetailsDAOImpl implements StudentOneTimeChargeDetailsDAO {
    
    @Override
    public int addStudentOneTimeChargeDetails(StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean) {
        Connection con = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;
        PreparedStatement pre3 = null;
        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();
            
            con.setAutoCommit(false);
            con.rollback();

            /* =========Insert One Time Charges Details Starts============*/
            pre1 = con.prepareStatement("INSERT INTO student_one_time_charge_details (STUDENT_ID, SECURITY_MONEY, PACKET_MONEY, TOTAL_TO_PAY, TOTAL_PAID_AMT,\n"
                    + "BALANCE_AMT,IS_PAID,ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME) VALUE(?,?,?,?,?,?,?,?,CURDATE(),NOW())");
            pre1.setInt(1, studentOneTimeChargeDetailsBean.getSTUDENT_ID());
            pre1.setInt(2, studentOneTimeChargeDetailsBean.getSECURITY_MONEY());
            pre1.setInt(3, studentOneTimeChargeDetailsBean.getPACKET_MONEY());
            pre1.setInt(4, studentOneTimeChargeDetailsBean.getTOTAL_TO_PAY());
            pre1.setInt(5, studentOneTimeChargeDetailsBean.getTOTAL_PAID_AMT());
            pre1.setInt(6, studentOneTimeChargeDetailsBean.getBALANCE_AMT());
            pre1.setInt(7, 1);
            pre1.setInt(8, studentOneTimeChargeDetailsBean.getENTRY_ID());
            
            pre1.addBatch();
            int[] stuOneTimeCharge = pre1.executeBatch();
            /* =========Insert One Time Charges Details Ends============*/

            /* =========Insert Hostel Monthly Fee Ledger Details Starts============*/
            StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
            StudentMasterBean studentMasterBean = studentMasterDAO.getStudentAllDetailsById(studentOneTimeChargeDetailsBean.getSTUDENT_ID());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String[] currDate = sdf.format(new Date()).split("-");
            String BILL_YEAR = currDate[0];
            int BILL_MONTH_ID = Integer.parseInt(currDate[1]);
            
            HostelMonthlyFeeLedgerService hostelMonthlyFeeLedgerService = new HostelMonthlyFeeLedgerServiceImpl();
            String BILL_NO = hostelMonthlyFeeLedgerService.generateBillNo(studentMasterBean.getSTUDENT_ID(), BILL_MONTH_ID, BILL_YEAR);
            
            pre2 = con.prepareStatement("INSERT INTO hostel_monthly_fee_ledger (STUDENT_ID, ADMISSION_NO, CLASS_ID, SECTION_ID, BILL_NO, BILL_MONTH_ID, "
                    + "BILL_YEAR, BALANCE_AMT,ENTRY_ID,ENTRY_DATE, ENTRY_DATE_TIME) \n"
                    + "VALUE (?,?,?,?,?,?,?,?,?,CURDATE(),NOW())");
            
            pre2.setInt(1, studentMasterBean.getSTUDENT_ID());
            pre2.setString(2, studentMasterBean.getADMISSION_NO());
            pre2.setInt(3, studentMasterBean.getCLASS_ID());
            pre2.setInt(4, studentMasterBean.getSECTION_ID());
            pre2.setString(5, BILL_NO);
            pre2.setInt(6, BILL_MONTH_ID);
            pre2.setString(7, BILL_YEAR);
            pre2.setInt(8, studentOneTimeChargeDetailsBean.getBALANCE_AMT());
            pre2.setInt(9, studentOneTimeChargeDetailsBean.getENTRY_ID());
            
            pre2.addBatch();
            int[] stuHostelMonthlyFee = pre2.executeBatch();

            /* =========Update Hostel Monthly Fee Ledger Details Ends=============*/
            
            /* =========Update Hostel Collection Details Starts==================*/
            pre3 = con.prepareStatement("INSERT INTO collection(STUDENT_ID, BILL_NO, PAID_AMT, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME)\n"
                    + "VALUE(?,?,?,?,CURDATE(),NOW())");
            
            pre3.setInt(1, studentMasterBean.getSTUDENT_ID());
            pre3.setString(2, BILL_NO);
            pre3.setInt(3, studentOneTimeChargeDetailsBean.getTOTAL_PAID_AMT());
            pre3.setInt(4, studentOneTimeChargeDetailsBean.getENTRY_ID());
            
            pre3.addBatch();
            int[] collection = pre3.executeBatch();
        
             /* =========Update Hostel Collection Details Ends=================*/
            if (stuOneTimeCharge.length == 1 && stuHostelMonthlyFee.length == 1 && collection.length == 1) {
                i++;
                con.commit();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (pre1 != null) {
                    pre1.close();
                }
                if (pre2 != null) {
                    pre2.close();
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
    public StudentOneTimeChargeDetailsBean getStudentOneTimeChargeDetailsByStudentId(int STUDENT_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean = new StudentOneTimeChargeDetailsBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM student_one_time_charge_details WHERE STUDENT_ID = ?");
            
            pre.setInt(1, STUDENT_ID);
            rs = pre.executeQuery();
            if (rs.next()) {
                studentOneTimeChargeDetailsBean.setSTUDENT_ONE_TIME_CHARGE_DETAILS_ID(rs.getInt("STUDENT_ONE_TIME_CHARGE_DETAILS_ID"));
                studentOneTimeChargeDetailsBean.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                studentOneTimeChargeDetailsBean.setSECURITY_MONEY(rs.getInt("SECURITY_MONEY"));
                studentOneTimeChargeDetailsBean.setPACKET_MONEY(rs.getInt("PACKET_MONEY"));
                studentOneTimeChargeDetailsBean.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                studentOneTimeChargeDetailsBean.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                studentOneTimeChargeDetailsBean.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                studentOneTimeChargeDetailsBean.setENTRY_ID(rs.getInt("ENTRY_ID"));
                studentOneTimeChargeDetailsBean.setENTRY_DATE(rs.getDate("ENTRY_DATE"));
                studentOneTimeChargeDetailsBean.setENTRY_DATE_TIME(rs.getTimestamp("ENTRY_DATE_TIME"));
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
        return studentOneTimeChargeDetailsBean;
    }
    
}
