/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HostelMonthlyFeeLedger.DAO;

import HostelMonthlyFeeLedger.Bean.HostelMonthlyFeeLedgerBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface HostelMonthlyFeeLedgerDAO {
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByBean(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByAdmissionNo(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByStudentId(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public int updateHostelMonthlyFeeLedger(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public int findArrearsAmount(int STUDENT_ID, int BILL_MONTH_ID, String BILL_YEAR, int CURRENT_MONTH_FEE);
    public int insertHostelMonthlyFeeLedger(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public HostelMonthlyFeeLedgerBean findLastMonthFeeLedgerByStudentId(int STUDENT_ID);
    public HostelMonthlyFeeLedgerBean findLastMonthFeeLedgerByAdmissionNo(String ADMISSION_NO);
    public ArrayList getStudentDuesList();
    public int getTotalDuesAmount();
             
}
