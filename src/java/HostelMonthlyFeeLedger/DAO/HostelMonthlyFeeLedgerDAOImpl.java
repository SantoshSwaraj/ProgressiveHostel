/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HostelMonthlyFeeLedger.DAO;

import HostelMonthlyFeeLedger.Bean.HostelMonthlyFeeLedgerBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                hostelMonthlyFeeLedgerBean1.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean1.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean1.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean1.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean1.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean1.setFLAG(rs.getInt("FLAG"));
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
        PreparedStatement pre = null;
        int i = 0;

        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("UPDATE hostel_monthly_fee_ledger SET CURRENT_MONTH_FEE = ?, ARREARS_AMT = ? ,\n"
                    + "TOTAL_TO_PAY = ?, TOTAL_PAID_AMT = ?, BALANCE_AMT = ?, ENTRY_ID = ?, FLAG = ?, ENTRY_DATE = CURDATE(), ENTRY_DATE_TIME = NOW() \n"
                    + "WHERE HOSTEL_MONTHLY_FEE_LEDGER_ID = ?");

            pre.setInt(1, hostelMonthlyFeeLedgerBean.getCURRENT_MONTH_FEE());
            pre.setInt(2, hostelMonthlyFeeLedgerBean.getARREARS_AMT());
            pre.setInt(3, hostelMonthlyFeeLedgerBean.getTOTAL_TO_PAY());
            pre.setInt(4, hostelMonthlyFeeLedgerBean.getTOTAL_PAID_AMT());
            pre.setInt(5, hostelMonthlyFeeLedgerBean.getBALANCE_AMT());
            pre.setInt(6, hostelMonthlyFeeLedgerBean.getENTRY_ID());
            pre.setInt(7, hostelMonthlyFeeLedgerBean.getFLAG());
            pre.setInt(8, hostelMonthlyFeeLedgerBean.getHOSTEL_MONTHLY_FEE_LEDGER_ID());

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
                hostelMonthlyFeeLedgerBean1.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean1.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean1.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean1.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean1.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean1.setFLAG(rs.getInt("FLAG"));
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
                hostelMonthlyFeeLedgerBean1.setBILL_MONTH_ID(rs.getInt("BILL_MONTH_ID"));
                hostelMonthlyFeeLedgerBean1.setBILL_YEAR(rs.getString("BILL_YEAR"));
                hostelMonthlyFeeLedgerBean1.setCURRENT_MONTH_FEE(rs.getInt("CURRENT_MONTH_FEE"));
                hostelMonthlyFeeLedgerBean1.setARREARS_AMT(rs.getInt("ARREARS_AMT"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_TO_PAY(rs.getInt("TOTAL_TO_PAY"));
                hostelMonthlyFeeLedgerBean1.setTOTAL_PAID_AMT(rs.getInt("TOTAL_PAID_AMT"));
                hostelMonthlyFeeLedgerBean1.setBALANCE_AMT(rs.getInt("BALANCE_AMT"));
                hostelMonthlyFeeLedgerBean1.setENTRY_ID(rs.getInt("ENTRY_ID"));
                hostelMonthlyFeeLedgerBean1.setFLAG(rs.getInt("FLAG"));
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
    public int findArrearsAmount(int STUDENT_ID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int BALANCE_AMT = 0;
        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("SELECT BALANCE_AMT FROM hostel_monthly_fee_ledger\n"
                    + "WHERE HOSTEL_MONTHLY_FEE_LEDGER_ID  = "
                    + "(SELECT MAX(HOSTEL_MONTHLY_FEE_LEDGER_ID) from hostel_monthly_fee_ledger where STUDENT_ID = ?)");

            pre.setInt(1, STUDENT_ID);
            rs = pre.executeQuery();

            if (rs.next()) {
                BALANCE_AMT = rs.getInt("BALANCE_AMT");

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
        return BALANCE_AMT;
    }

    @Override
    public int insertHostelMonthlyFeeLedger(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean) {
        Connection con = null;
        PreparedStatement pre = null;
        int i = 0;

        try {
            con = DataBaseConnection.Connection.con();
            pre = con.prepareStatement("INSERT INTO hostel_monthly_fee_ledger (STUDENT_ID, ADMISSION_NO, CLASS_ID, SECTION_ID,"
                    + " BILL_MONTH_ID, BILL_YEAR, CURRENT_MONTH_FEE,\n"
                    + "ARREARS_AMT, TOTAL_TO_PAY, TOTAL_PAID_AMT, BALANCE_AMT, ENTRY_ID, FLAG, ENTRY_DATE, ENTRY_DATE_TIME)\n"
                    + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(), NOW())");

            pre.setInt(1, hostelMonthlyFeeLedgerBean.getSTUDENT_ID());
            pre.setString(2, hostelMonthlyFeeLedgerBean.getADMISSION_NO());
            pre.setInt(3, hostelMonthlyFeeLedgerBean.getCLASS_ID());
            pre.setInt(4, hostelMonthlyFeeLedgerBean.getSECTION_ID());
            pre.setInt(5, hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID());
            pre.setString(6, hostelMonthlyFeeLedgerBean.getBILL_YEAR());
            pre.setInt(7, hostelMonthlyFeeLedgerBean.getCURRENT_MONTH_FEE());
            pre.setInt(8, hostelMonthlyFeeLedgerBean.getARREARS_AMT());
            pre.setInt(9, hostelMonthlyFeeLedgerBean.getTOTAL_TO_PAY());
            pre.setInt(10, hostelMonthlyFeeLedgerBean.getTOTAL_PAID_AMT());
            pre.setInt(11, hostelMonthlyFeeLedgerBean.getBALANCE_AMT());
            pre.setInt(12, hostelMonthlyFeeLedgerBean.getENTRY_ID());
            pre.setInt(13, hostelMonthlyFeeLedgerBean.getFLAG());
            

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
