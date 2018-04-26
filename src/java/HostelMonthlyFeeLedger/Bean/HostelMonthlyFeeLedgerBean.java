/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HostelMonthlyFeeLedger.Bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Santosh Kushwaha
 */
public class HostelMonthlyFeeLedgerBean {
    private Integer HOSTEL_MONTHLY_FEE_LEDGER_ID;
    private Integer STUDENT_ID;
    private String ADMISSION_NO;
    private Integer CLASS_ID;
    private Integer SECTION_ID;
    private Integer BILL_MONTH_ID;
    private String BILL_YEAR;
    private Integer CURRENT_MONTH_FEE;
    private Integer ARREARS_AMT;
    private Integer TOTAL_TO_PAY;
    private Integer TOTAL_PAID_AMT;
    private Integer BALANCE_AMT;
    private Integer ENTRY_ID;
    private Integer FLAG;
    private Date ENTRY_DATE;
    private Timestamp ENTRY_DATE_TIME;

    /**
     * @return the HOSTEL_MONTHLY_FEE_LEDGER_ID
     */
    public Integer getHOSTEL_MONTHLY_FEE_LEDGER_ID() {
        return HOSTEL_MONTHLY_FEE_LEDGER_ID;
    }

    /**
     * @param HOSTEL_MONTHLY_FEE_LEDGER_ID the HOSTEL_MONTHLY_FEE_LEDGER_ID to set
     */
    public void setHOSTEL_MONTHLY_FEE_LEDGER_ID(Integer HOSTEL_MONTHLY_FEE_LEDGER_ID) {
        this.HOSTEL_MONTHLY_FEE_LEDGER_ID = HOSTEL_MONTHLY_FEE_LEDGER_ID;
    }

    /**
     * @return the STUDENT_ID
     */
    public Integer getSTUDENT_ID() {
        return STUDENT_ID;
    }

    /**
     * @param STUDENT_ID the STUDENT_ID to set
     */
    public void setSTUDENT_ID(Integer STUDENT_ID) {
        this.STUDENT_ID = STUDENT_ID;
    }

    /**
     * @return the ADMISSION_NO
     */
    public String getADMISSION_NO() {
        return ADMISSION_NO;
    }

    /**
     * @param ADMISSION_NO the ADMISSION_NO to set
     */
    public void setADMISSION_NO(String ADMISSION_NO) {
        this.ADMISSION_NO = ADMISSION_NO;
    }

    /**
     * @return the CLASS_ID
     */
    public Integer getCLASS_ID() {
        return CLASS_ID;
    }

    /**
     * @param CLASS_ID the CLASS_ID to set
     */
    public void setCLASS_ID(Integer CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }

    /**
     * @return the SECTION_ID
     */
    public Integer getSECTION_ID() {
        return SECTION_ID;
    }

    /**
     * @param SECTION_ID the SECTION_ID to set
     */
    public void setSECTION_ID(Integer SECTION_ID) {
        this.SECTION_ID = SECTION_ID;
    }

    /**
     * @return the BILL_MONTH_ID
     */
    public Integer getBILL_MONTH_ID() {
        return BILL_MONTH_ID;
    }

    /**
     * @param BILL_MONTH_ID the BILL_MONTH_ID to set
     */
    public void setBILL_MONTH_ID(Integer BILL_MONTH_ID) {
        this.BILL_MONTH_ID = BILL_MONTH_ID;
    }

    /**
     * @return the BILL_YEAR
     */
    public String getBILL_YEAR() {
        return BILL_YEAR;
    }

    /**
     * @param BILL_YEAR the BILL_YEAR to set
     */
    public void setBILL_YEAR(String BILL_YEAR) {
        this.BILL_YEAR = BILL_YEAR;
    }

    /**
     * @return the CURRENT_MONTH_FEE
     */
    public Integer getCURRENT_MONTH_FEE() {
        return CURRENT_MONTH_FEE;
    }

    /**
     * @param CURRENT_MONTH_FEE the CURRENT_MONTH_FEE to set
     */
    public void setCURRENT_MONTH_FEE(Integer CURRENT_MONTH_FEE) {
        this.CURRENT_MONTH_FEE = CURRENT_MONTH_FEE;
    }

    /**
     * @return the ARREARS_AMT
     */
    public Integer getARREARS_AMT() {
        return ARREARS_AMT;
    }

    /**
     * @param ARREARS_AMT the ARREARS_AMT to set
     */
    public void setARREARS_AMT(Integer ARREARS_AMT) {
        this.ARREARS_AMT = ARREARS_AMT;
    }

    /**
     * @return the TOTAL_TO_PAY
     */
    public Integer getTOTAL_TO_PAY() {
        return TOTAL_TO_PAY;
    }

    /**
     * @param TOTAL_TO_PAY the TOTAL_TO_PAY to set
     */
    public void setTOTAL_TO_PAY(Integer TOTAL_TO_PAY) {
        this.TOTAL_TO_PAY = TOTAL_TO_PAY;
    }

    /**
     * @return the TOTAL_PAID_AMT
     */
    public Integer getTOTAL_PAID_AMT() {
        return TOTAL_PAID_AMT;
    }

    /**
     * @param TOTAL_PAID_AMT the TOTAL_PAID_AMT to set
     */
    public void setTOTAL_PAID_AMT(Integer TOTAL_PAID_AMT) {
        this.TOTAL_PAID_AMT = TOTAL_PAID_AMT;
    }

    /**
     * @return the BALANCE_AMT
     */
    public Integer getBALANCE_AMT() {
        return BALANCE_AMT;
    }

    /**
     * @param BALANCE_AMT the BALANCE_AMT to set
     */
    public void setBALANCE_AMT(Integer BALANCE_AMT) {
        this.BALANCE_AMT = BALANCE_AMT;
    }

    /**
     * @return the ENTRY_ID
     */
    public Integer getENTRY_ID() {
        return ENTRY_ID;
    }

    /**
     * @param ENTRY_ID the ENTRY_ID to set
     */
    public void setENTRY_ID(Integer ENTRY_ID) {
        this.ENTRY_ID = ENTRY_ID;
    }

    /**
     * @return the FLAG
     */
    public Integer getFLAG() {
        return FLAG;
    }

    /**
     * @param FLAG the FLAG to set
     */
    public void setFLAG(Integer FLAG) {
        this.FLAG = FLAG;
    }

    /**
     * @return the ENTRY_DATE
     */
    public Date getENTRY_DATE() {
        return ENTRY_DATE;
    }

    /**
     * @param ENTRY_DATE the ENTRY_DATE to set
     */
    public void setENTRY_DATE(Date ENTRY_DATE) {
        this.ENTRY_DATE = ENTRY_DATE;
    }

    /**
     * @return the ENTRY_DATE_TIME
     */
    public Timestamp getENTRY_DATE_TIME() {
        return ENTRY_DATE_TIME;
    }

    /**
     * @param ENTRY_DATE_TIME the ENTRY_DATE_TIME to set
     */
    public void setENTRY_DATE_TIME(Timestamp ENTRY_DATE_TIME) {
        this.ENTRY_DATE_TIME = ENTRY_DATE_TIME;
    }

    

}
