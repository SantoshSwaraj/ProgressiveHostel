/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StudentOneTimeChargeDetails.Bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentOneTimeChargeDetailsBean {
    private Integer STUDENT_ONE_TIME_CHARGE_DETAILS_ID;
    private Integer STUDENT_ID;
    private Integer SECURITY_MONEY;
    private Integer PACKET_MONEY;
    private Integer TOTAL_TO_PAY;
    private Integer TOTAL_PAID_AMT;
    private Integer BALANCE_AMT;
    private Integer ENTRY_ID;
    private Date ENTRY_DATE;
    private Timestamp ENTRY_DATE_TIME; 

    /**
     * @return the STUDENT_ONE_TIME_CHARGE_DETAILS_ID
     */
    public Integer getSTUDENT_ONE_TIME_CHARGE_DETAILS_ID() {
        return STUDENT_ONE_TIME_CHARGE_DETAILS_ID;
    }

    /**
     * @param STUDENT_ONE_TIME_CHARGE_DETAILS_ID the STUDENT_ONE_TIME_CHARGE_DETAILS_ID to set
     */
    public void setSTUDENT_ONE_TIME_CHARGE_DETAILS_ID(Integer STUDENT_ONE_TIME_CHARGE_DETAILS_ID) {
        this.STUDENT_ONE_TIME_CHARGE_DETAILS_ID = STUDENT_ONE_TIME_CHARGE_DETAILS_ID;
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
     * @return the SECURITY_MONEY
     */
    public Integer getSECURITY_MONEY() {
        return SECURITY_MONEY;
    }

    /**
     * @param SECURITY_MONEY the SECURITY_MONEY to set
     */
    public void setSECURITY_MONEY(Integer SECURITY_MONEY) {
        this.SECURITY_MONEY = SECURITY_MONEY;
    }

    /**
     * @return the PACKET_MONEY
     */
    public Integer getPACKET_MONEY() {
        return PACKET_MONEY;
    }

    /**
     * @param PACKET_MONEY the PACKET_MONEY to set
     */
    public void setPACKET_MONEY(Integer PACKET_MONEY) {
        this.PACKET_MONEY = PACKET_MONEY;
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
