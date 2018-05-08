/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HostelMonthlyFeeLedger.DAO;

import Classes.Bean.ClassBean;
import HostelMonthlyFeeLedger.Bean.HostelMonthlyFeeLedgerBean;
import HostelMonthlyFeeLedger.Service.HostelMonthlyFeeLedgerService;
import HostelMonthlyFeeLedger.Service.HostelMonthlyFeeLedgerServiceImpl;
import Section.Bean.SectionBean;
import Session.Bean.SessionBean;
import StudentMaster.Bean.StudentMasterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Santosh Kushwaha
 */
public class HostelMonthlyFeeLedgerDAOImpl implements HostelMonthlyFeeLedgerDAO {

    @Override
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByBean(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean1 = new HostelMonthlyFeeLedgerBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM hostel_monthly_fee_ledger\n"
                    + "WHERE STUDENT_ID = ? AND ADMISSION_NO = ? AND CLASS_ID = ? AND SECTION_ID = ?\n"
                    + "AND BILL_MONTH_ID = ? AND BILL_YEAR = ?");

            pre.setInt(1, hostelMonthlyFeeLedgerBean.getSTUDENT_ID());
            pre.setString(2, hostelMonthlyFeeLedgerBean.getADMISSION_NO());
            pre.setInt(3, hostelMonthlyFeeLedgerBean.getCLASS_ID());
            pre.setInt(4, hostelMonthlyFeeLedgerBean.getSECTION_ID());
            pre.setInt(5, hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID());
            pre.setString(6, hostelMonthlyFeeLedgerBean.getBILL_YEAR());

            rs = pre.executeQuery();

            if (rs.next()) {
                hostelMonthlyFeeLedgerBean1.setHOSTEL_MONTHLY_FEE_LEDGER_ID(rs.getInt("HOSTEL_MONTHLY_FEE_LEDGER_ID"));
                hostelMonthlyFeeLedgerBean1.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                hostelMonthlyFeeLedgerBean1.setADMISSION_NO(rs.getString("ADMISSION_NO"));
                hostelMonthlyFeeLedgerBean1.setCLASS_ID(rs.getInt("CLASS_ID"));
                hostelMonthlyFeeLedgerBean1.setSECTION_ID(rs.getInt("SECTION_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_NO(rs.getString("BILL_NO"));
                hostelMonthlyFeeLedgerBean1.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean1.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean1.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean1.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean1.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean1.setENTRY_DATE(rs.getDate("ENTRY_DATE"));
                hostelMonthlyFeeLedgerBean1.setENTRY_DATE_TIME(rs.getTimestamp("ENTRY_DATE_TIME"));
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
        return hostelMonthlyFeeLedgerBean1;
    }

    @Override
    public int updateHostelMonthlyFeeLedger(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean) {
        Connection con = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;
        int i = 0;

        try {
            con = DataBaseConnection.Connection.con();
            con.setAutoCommit(false);
            con.rollback();

            /* ========= Update Hostel Monthly Fee Ledger Starts============*/
            pre1 = con.prepareStatement("UPDATE hostel_monthly_fee_ledger SET CURRENT_MONTH_FEE = ?, ARREARS_AMT = ? ,\n"
                    + "TOTAL_TO_PAY = ?, TOTAL_PAID_AMT = ?, BALANCE_AMT = ?, IS_PAID_ONCE = ?, ENTRY_ID = ?, ENTRY_DATE = CURDATE(), ENTRY_DATE_TIME = NOW() \n"
                    + "WHERE HOSTEL_MONTHLY_FEE_LEDGER_ID = ?");

            pre1.setInt(1, hostelMonthlyFeeLedgerBean.getCURRENT_MONTH_FEE());
            pre1.setInt(2, hostelMonthlyFeeLedgerBean.getARREARS_AMT());
            pre1.setInt(3, hostelMonthlyFeeLedgerBean.getTOTAL_TO_PAY());
            pre1.setInt(4, hostelMonthlyFeeLedgerBean.getTOTAL_PAID_AMT());
            pre1.setInt(5, hostelMonthlyFeeLedgerBean.getBALANCE_AMT());
            pre1.setInt(6, 1);
            pre1.setInt(7, hostelMonthlyFeeLedgerBean.getENTRY_ID());
            pre1.setInt(8, hostelMonthlyFeeLedgerBean.getHOSTEL_MONTHLY_FEE_LEDGER_ID());

            pre1.addBatch();

            int[] hostelLedger = pre1.executeBatch();
            /* ========= Update Hostel Monthly Fee Ledger Ends============*/

            /* =========Update Hostel Collection Details Starts==================*/
            pre2 = con.prepareStatement("INSERT INTO collection(STUDENT_ID, BILL_NO, PAID_AMT, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME)\n"
                    + "VALUE(?,?,?,?,CURDATE(),NOW())");

            pre2.setInt(1, hostelMonthlyFeeLedgerBean.getSTUDENT_ID());
            pre2.setString(2, hostelMonthlyFeeLedgerBean.getBILL_NO());
            pre2.setInt(3, hostelMonthlyFeeLedgerBean.getTOTAL_PAID_AMT());
            pre2.setInt(4, hostelMonthlyFeeLedgerBean.getENTRY_ID());

            pre2.addBatch();
            int[] collection = pre2.executeBatch();
            /* =========Update Hostel Collection Details Ends=================*/
            if (hostelLedger.length == 1 && collection.length == 1) {
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
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByAdmissionNo(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean1 = new HostelMonthlyFeeLedgerBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM hostel_monthly_fee_ledger\n"
                    + "WHERE ADMISSION_NO = ? AND BILL_MONTH_ID = ? AND BILL_YEAR = ?");

            pre.setString(1, hostelMonthlyFeeLedgerBean.getADMISSION_NO());
            pre.setInt(2, hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID());
            pre.setString(3, hostelMonthlyFeeLedgerBean.getBILL_YEAR());

            rs = pre.executeQuery();

            if (rs.next()) {
                hostelMonthlyFeeLedgerBean1.setHOSTEL_MONTHLY_FEE_LEDGER_ID(rs.getInt("HOSTEL_MONTHLY_FEE_LEDGER_ID"));
                hostelMonthlyFeeLedgerBean1.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                hostelMonthlyFeeLedgerBean1.setADMISSION_NO(rs.getString("ADMISSION_NO"));
                hostelMonthlyFeeLedgerBean1.setCLASS_ID(rs.getInt("CLASS_ID"));
                hostelMonthlyFeeLedgerBean1.setSECTION_ID(rs.getInt("SECTION_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_NO(rs.getString("BILL_NO"));
                hostelMonthlyFeeLedgerBean1.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean1.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean1.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean1.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean1.setIS_PAID_ONCE(rs.getInt("IS_PAID_ONCE"));
                hostelMonthlyFeeLedgerBean1.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean1.setENTRY_DATE(rs.getDate("ENTRY_DATE"));
                hostelMonthlyFeeLedgerBean1.setENTRY_DATE_TIME(rs.getTimestamp("ENTRY_DATE_TIME"));
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
        return hostelMonthlyFeeLedgerBean1;
    }

    @Override
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByStudentId(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean1 = new HostelMonthlyFeeLedgerBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM hostel_monthly_fee_ledger\n"
                    + "WHERE STUDENT_ID = ? AND BILL_MONTH_ID = ? AND BILL_YEAR = ?");

            pre.setInt(1, hostelMonthlyFeeLedgerBean.getSTUDENT_ID());
            pre.setInt(2, hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID());
            pre.setString(3, hostelMonthlyFeeLedgerBean.getBILL_YEAR());

            rs = pre.executeQuery();

            if (rs.next()) {
                hostelMonthlyFeeLedgerBean1.setHOSTEL_MONTHLY_FEE_LEDGER_ID(rs.getInt("HOSTEL_MONTHLY_FEE_LEDGER_ID"));
                hostelMonthlyFeeLedgerBean1.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                hostelMonthlyFeeLedgerBean1.setADMISSION_NO(rs.getString("ADMISSION_NO"));
                hostelMonthlyFeeLedgerBean1.setCLASS_ID(rs.getInt("CLASS_ID"));
                hostelMonthlyFeeLedgerBean1.setSECTION_ID(rs.getInt("SECTION_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_NO(rs.getString("BILL_NO"));
                hostelMonthlyFeeLedgerBean1.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean1.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean1.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean1.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean1.setIS_PAID_ONCE(rs.getInt("IS_PAID_ONCE"));
                hostelMonthlyFeeLedgerBean1.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean1.setENTRY_DATE(rs.getDate("ENTRY_DATE"));
                hostelMonthlyFeeLedgerBean1.setENTRY_DATE_TIME(rs.getTimestamp("ENTRY_DATE_TIME"));
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
        return hostelMonthlyFeeLedgerBean1;
    }

    @Override
    public int findArrearsAmount(int STUDENT_ID, int BILL_MONTH_ID, String BILL_YEAR, int CURRENT_MONTH_FEE) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int LAST_BILL_MONTH_ID = 0;
        String LAST_BILL_YEAR = "";
        int BALANCE_AMT = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT BILL_MONTH_ID,BILL_YEAR,BALANCE_AMT FROM hostel_monthly_fee_ledger\n"
                    + "WHERE HOSTEL_MONTHLY_FEE_LEDGER_ID  = "
                    + "(SELECT MAX(HOSTEL_MONTHLY_FEE_LEDGER_ID) from hostel_monthly_fee_ledger where STUDENT_ID = ?)");

            pre.setInt(1, STUDENT_ID);
            rs = pre.executeQuery();

            if (rs.next()) {
                LAST_BILL_MONTH_ID = rs.getInt("BILL_MONTH_ID");
                LAST_BILL_YEAR = rs.getString("BILL_YEAR");
                BALANCE_AMT = rs.getInt("BALANCE_AMT");

            }
            BALANCE_AMT = (((Integer.parseInt(BILL_YEAR) - Integer.parseInt(LAST_BILL_YEAR)) * 12 + (BILL_MONTH_ID - LAST_BILL_MONTH_ID) - 1) * CURRENT_MONTH_FEE) + BALANCE_AMT;

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
        return BALANCE_AMT;
    }

    @Override
    public int insertHostelMonthlyFeeLedger(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean) {
        Connection con = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;
        int i = 0;

        HostelMonthlyFeeLedgerService hostelMonthlyFeeLedgerService = new HostelMonthlyFeeLedgerServiceImpl();
        try {
            con = DataBaseConnection.Connection.con();
            con.setAutoCommit(false);
            con.rollback();
            /* =========Insert Monthly Hostel Fee Starts============*/
            pre1 = con.prepareStatement("INSERT INTO hostel_monthly_fee_ledger (STUDENT_ID, ADMISSION_NO, CLASS_ID, SECTION_ID,"
                    + "BILL_NO, BILL_MONTH_ID, BILL_YEAR, CURRENT_MONTH_FEE,\n"
                    + "ARREARS_AMT, TOTAL_TO_PAY, TOTAL_PAID_AMT, BALANCE_AMT,IS_PAID_ONCE, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME)\n"
                    + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(), NOW())");

            pre1.setInt(1, hostelMonthlyFeeLedgerBean.getSTUDENT_ID());
            pre1.setString(2, hostelMonthlyFeeLedgerBean.getADMISSION_NO());
            pre1.setInt(3, hostelMonthlyFeeLedgerBean.getCLASS_ID());
            pre1.setInt(4, hostelMonthlyFeeLedgerBean.getSECTION_ID());
            pre1.setString(5, hostelMonthlyFeeLedgerBean.getBILL_NO());
            pre1.setInt(6, hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID());
            pre1.setString(7, hostelMonthlyFeeLedgerBean.getBILL_YEAR());
            pre1.setInt(8, hostelMonthlyFeeLedgerBean.getCURRENT_MONTH_FEE());
            pre1.setInt(9, hostelMonthlyFeeLedgerBean.getARREARS_AMT());
            pre1.setInt(10, hostelMonthlyFeeLedgerBean.getTOTAL_TO_PAY());
            pre1.setInt(11, hostelMonthlyFeeLedgerBean.getTOTAL_PAID_AMT());
            pre1.setInt(12, hostelMonthlyFeeLedgerBean.getBALANCE_AMT());
            pre1.setInt(13, 1);
            pre1.setInt(14, hostelMonthlyFeeLedgerBean.getENTRY_ID());

            pre1.addBatch();

            int[] hostelLedger = pre1.executeBatch();
            /* =========Insert Monthly Hostel Fee Ends============*/

            /* =========Update Hostel Collection Details Starts==================*/
            pre2 = con.prepareStatement("INSERT INTO collection(STUDENT_ID, BILL_NO, PAID_AMT, ENTRY_ID, ENTRY_DATE, ENTRY_DATE_TIME)\n"
                    + "VALUE(?,?,?,?,CURDATE(),NOW())");

            pre2.setInt(1, hostelMonthlyFeeLedgerBean.getSTUDENT_ID());
            pre2.setString(2, hostelMonthlyFeeLedgerBean.getBILL_NO());
            pre2.setInt(3, hostelMonthlyFeeLedgerBean.getTOTAL_PAID_AMT());
            pre2.setInt(4, hostelMonthlyFeeLedgerBean.getENTRY_ID());

            pre2.addBatch();
            int[] collection = pre2.executeBatch();
            /* =========Update Hostel Collection Details Ends=================*/

            if (hostelLedger.length == 1 && collection.length == 1) {
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
    public HostelMonthlyFeeLedgerBean findLastMonthFeeLedgerByStudentId(int STUDENT_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean = new HostelMonthlyFeeLedgerBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM hostel_monthly_fee_ledger \n"
                    + "WHERE HOSTEL_MONTHLY_FEE_LEDGER_ID = (SELECT MAX(HOSTEL_MONTHLY_FEE_LEDGER_ID) FROM hostel_monthly_fee_ledger WHERE STUDENT_ID = ?)");

            pre.setInt(1, STUDENT_ID);

            rs = pre.executeQuery();
            if (rs.next()) {
                hostelMonthlyFeeLedgerBean.setHOSTEL_MONTHLY_FEE_LEDGER_ID(rs.getInt("HOSTEL_MONTHLY_FEE_LEDGER_ID"));
                hostelMonthlyFeeLedgerBean.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                hostelMonthlyFeeLedgerBean.setADMISSION_NO(rs.getString("ADMISSION_NO"));
                hostelMonthlyFeeLedgerBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                hostelMonthlyFeeLedgerBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                hostelMonthlyFeeLedgerBean.setBILL_NO(rs.getString("BILL_NO"));
                hostelMonthlyFeeLedgerBean.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean.setIS_PAID_ONCE(rs.getInt("IS_PAID_ONCE"));
                hostelMonthlyFeeLedgerBean.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean.setENTRY_DATE(rs.getDate("ENTRY_DATE"));
                hostelMonthlyFeeLedgerBean.setENTRY_DATE_TIME(rs.getTimestamp("ENTRY_DATE_TIME"));

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
        return hostelMonthlyFeeLedgerBean;
    }

    @Override
    public HostelMonthlyFeeLedgerBean findLastMonthFeeLedgerByAdmissionNo(String ADMISSION_NO) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean = new HostelMonthlyFeeLedgerBean();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT * FROM hostel_monthly_fee_ledger \n"
                    + "WHERE HOSTEL_MONTHLY_FEE_LEDGER_ID = \n"
                    + "(SELECT MAX(HOSTEL_MONTHLY_FEE_LEDGER_ID) FROM hostel_monthly_fee_ledger WHERE ADMISSION_NO = ?)");

            pre.setString(1, ADMISSION_NO);

            rs = pre.executeQuery();
            if (rs.next()) {
                hostelMonthlyFeeLedgerBean.setHOSTEL_MONTHLY_FEE_LEDGER_ID(rs.getInt("HOSTEL_MONTHLY_FEE_LEDGER_ID"));
                hostelMonthlyFeeLedgerBean.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                hostelMonthlyFeeLedgerBean.setADMISSION_NO(rs.getString("ADMISSION_NO"));
                hostelMonthlyFeeLedgerBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                hostelMonthlyFeeLedgerBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                hostelMonthlyFeeLedgerBean.setBILL_NO(rs.getString("BILL_NO"));
                hostelMonthlyFeeLedgerBean.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean.setIS_PAID_ONCE(rs.getInt("IS_PAID_ONCE"));
                hostelMonthlyFeeLedgerBean.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean.setENTRY_DATE(rs.getDate("ENTRY_DATE"));
                hostelMonthlyFeeLedgerBean.setENTRY_DATE_TIME(rs.getTimestamp("ENTRY_DATE_TIME"));

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
        return hostelMonthlyFeeLedgerBean;

    }

    @Override
    public ArrayList getStudentDuesList() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<HostelMonthlyFeeLedgerBean> list = new ArrayList<>();
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT sess.SESSION_ID,sess.SESSION, sm.STUDENT_ID, sm.STUDENT_NAME, sm.ADMISSION_NO,\n"
                    + "sm.ENTRY_DATE as ADMISSION_DATE,class.CLASS_ID, class.CLASS_NAME, sec.SECTION_ID, sec.SECTION_NAME,\n"
                    + "sm.STUDENT_ROLL_NO, hmfl.BALANCE_AMT, hmfl.CURRENT_MONTH_FEE,\n"
                    + "hmfl.BILL_MONTH_ID, hmfl.BILL_YEAR\n"
                    + "FROM hostel_monthly_fee_ledger as hmfl\n"
                    + "inner join student_master as sm\n"
                    + "on hmfl.STUDENT_ID = sm.STUDENT_ID\n"
                    + "inner join session as sess\n"
                    + "on sm.SESSION_ID = sess.SESSION_ID\n"
                    + "inner join classes as class\n"
                    + "on class.CLASS_ID = sm.CLASS_ID\n"
                    + "inner join section as sec\n"
                    + "on sec.SECTION_ID = sm.SECTION_ID\n"
                    + "WHERE hmfl.BILL_NO IN (SELECT MAX(BILL_NO) FROM hostel_monthly_fee_ledger GROUP BY STUDENT_ID)");

            rs = pre.executeQuery();
            while (rs.next()) {
                HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean = new HostelMonthlyFeeLedgerBean();
                hostelMonthlyFeeLedgerBean.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));

                SessionBean sessionBean = new SessionBean();
                sessionBean.setSESSION_ID(rs.getInt("SESSION_ID"));
                sessionBean.setSESSION(rs.getString("SESSION"));
                hostelMonthlyFeeLedgerBean.setSessionBean(sessionBean);

                StudentMasterBean studentMasterBean = new StudentMasterBean();
                studentMasterBean.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                studentMasterBean.setSTUDENT_NAME(rs.getString("STUDENT_NAME"));
                studentMasterBean.setADMISSION_NO(rs.getString("ADMISSION_NO"));
                studentMasterBean.setENTRY_DATE(rs.getDate("ADMISSION_DATE"));
                studentMasterBean.setSTUDENT_ROLL_NO(rs.getInt("STUDENT_ROLL_NO"));
                hostelMonthlyFeeLedgerBean.setStudentMasterBean(studentMasterBean);

                ClassBean classBean = new ClassBean();
                classBean.setCLASS_ID(rs.getInt("CLASS_ID"));
                classBean.setCLASS_NAME(rs.getString("CLASS_NAME"));
                hostelMonthlyFeeLedgerBean.setClassBean(classBean);

                SectionBean sectionBean = new SectionBean();
                sectionBean.setSECTION_ID(rs.getInt("SECTION_ID"));
                sectionBean.setSECTION_NAME(rs.getString("SECTION_NAME"));
                hostelMonthlyFeeLedgerBean.setSectionBean(sectionBean);

                list.add(hostelMonthlyFeeLedgerBean);

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
        return list;
    }

    @Override
    public int getTotalDuesAmount() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<HostelMonthlyFeeLedgerBean> hmflbList = new ArrayList<>();
        int totalDuesAmount = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT STUDENT_ID, BILL_MONTH_ID, BILL_YEAR, BALANCE_AMT, CURRENT_MONTH_FEE FROM hostel_monthly_fee_ledger \n"
                    + "WHERE BILL_NO IN (SELECT MAX(BILL_NO) FROM hostel_monthly_fee_ledger GROUP BY STUDENT_ID)");

            rs = pre.executeQuery();

            while (rs.next()) {
                HostelMonthlyFeeLedgerBean hmflb = new HostelMonthlyFeeLedgerBean();
                hmflb.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
                hmflb.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hmflb.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hmflb.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hmflb.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String[] currDate = sdf.format(new Date()).split("-");
                int CURR_YEAR = Integer.parseInt(currDate[0]);
                int CURR_MONTH_ID = Integer.parseInt(currDate[1]);

                totalDuesAmount += ((((CURR_YEAR - Integer.parseInt(hmflb.getBILL_YEAR())) * 12) + (CURR_MONTH_ID - hmflb.getBILL_MONTH_ID())) * hmflb.getCURRENT_MONTH_FEE()) +hmflb.getBALANCE_AMT();

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
        return totalDuesAmount;
    }

}
