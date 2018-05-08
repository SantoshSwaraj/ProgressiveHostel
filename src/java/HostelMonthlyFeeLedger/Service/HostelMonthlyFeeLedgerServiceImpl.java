/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HostelMonthlyFeeLedger.Service;

/**
 *
 * @author Santosh Kushwaha
 */
public class HostelMonthlyFeeLedgerServiceImpl implements HostelMonthlyFeeLedgerService{

    @Override
    public String generateBillNo(int STUDENT_ID, int BILL_MONTH_ID, String BILL_YEAR) {
        return STUDENT_ID+"/"+BILL_MONTH_ID+"/"+BILL_YEAR;
    }
    
}
