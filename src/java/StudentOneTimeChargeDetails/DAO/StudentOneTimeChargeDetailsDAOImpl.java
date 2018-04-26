/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentOneTimeChargeDetails.DAO;

import StudentMaster.Bean.StudentMasterBean;
import StudentMaster.DAO.StudentMasterDAO;
import StudentMaster.DAO.StudentMasterDAOImpl;
import StudentOneTimeChargeDetails.Bean.StudentOneTimeChargeDetailsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mishra
 */
public class StudentOneTimeChargeDetailsDAOImpl implements StudentOneTimeChargeDetailsDAO {

    @Override
    public int addStudentOneTimeChargeDetails(StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean) {
        Connection con = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;

        int i = 0;
        try {
            con = DataBaseConnection.Connection.con();

            con.setAutoCommit(false);
            con.rollback();

            /* =========Update One Time Charges Details Starts============*/
            pre1 = con.prepareStatement("UPDATE student_one_time_charge_details SET SECURITY_MONEY = ?, PACKET_MONEY = ?, TOTAL_TO_PAY = ?, \n"
                    + "TOTAL_PAID_AMT = ?, BALANCE_AMT = ?, ENTRY_ID = ? WHERE STUDENT_ID = ?");
            pre1.setInt(1, studentOneTimeChargeDetailsBean.getSECURITY_MONEY());
            pre1.setInt(2, studentOneTimeChargeDetailsBean.getPACKET_MONEY());
            pre1.setInt(3, studentOneTimeChargeDetailsBean.getTOTAL_TO_PAY());
            pre1.setInt(4, studentOneTimeChargeDetailsBean.getTOTAL_PAID_AMT());
            pre1.setInt(5, studentOneTimeChargeDetailsBean.getBALANCE_AMT());
            pre1.setInt(6, studentOneTimeChargeDetailsBean.getENTRY_ID());
            pre1.setInt(7, studentOneTimeChargeDetailsBean.getSTUDENT_ID());

            pre1.addBatch();
            int[] stuOneTimeCharge = pre1.executeBatch();
            /* =========Update One Time Charges Details Ends============*/

            /* =========Update Hostel Monthly Fee Ledger Details Starts============*/
            StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
            StudentMasterBean studentMasterBean = studentMasterDAO.getStudentAllDetailsById(studentOneTimeChargeDetailsBean.getSTUDENT_ID());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String[] currDate = sdf.format(new Date()).split("-");
            String BILL_YEAR = currDate[0];
            int BILL_MONTH_ID = Integer.parseInt(currDate[1]);

            pre2 = con.prepareStatement("INSERT INTO hostel_monthly_fee_ledger (STUDENT_ID, ADMISSION_NO, CLASS_ID, SECTION_ID, BILL_MONTH_ID, "
                    + "BILL_YEAR, BALANCE_AMT, ENTRY_ID, FLAG, ENTRY_DATE, ENTRY_DATE_TIME) \n"
                    + "VALUE (?,?,?,?,?,?,?,?,?,CURDATE(),NOW())");

            pre2.setInt(1, studentMasterBean.getSTUDENT_ID());
            pre2.setString(2, studentMasterBean.getADMISSION_NO());
            pre2.setInt(3, studentMasterBean.getCLASS_ID());
            pre2.setInt(4, studentMasterBean.getSECTION_ID());
            pre2.setInt(5, BILL_MONTH_ID);
            pre2.setString(6, BILL_YEAR);
            pre2.setInt(7, studentOneTimeChargeDetailsBean.getBALANCE_AMT());
            pre2.setInt(8, studentOneTimeChargeDetailsBean.getENTRY_ID());
            pre2.setInt(9, 0);  

            pre2.addBatch();
            int[] stuHostelMonthlyFee = pre2.executeBatch();

            /* =========Update Hostel Monthly Fee Ledger Details Ends=============*/
            if(stuOneTimeCharge.length == 1 && stuHostelMonthlyFee.length == 1){
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

}
