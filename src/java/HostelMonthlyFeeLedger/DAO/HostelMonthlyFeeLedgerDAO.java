/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HostelMonthlyFeeLedger.DAO;

import HostelMonthlyFeeLedger.Bean.HostelMonthlyFeeLedgerBean;

/**
 *
 * @author Santosh Kushwaha
 */
public interface HostelMonthlyFeeLedgerDAO {
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByBean(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByAdmissionNo(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public HostelMonthlyFeeLedgerBean searchStudentMonthlyFeeLedgerByStudentId(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public int updateHostelMonthlyFeeLedger(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
    public int findArrearsAmount(int STUDENT_ID);
    public int insertHostelMonthlyFeeLedger(HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean);
            
}
