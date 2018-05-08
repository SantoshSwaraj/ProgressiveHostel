/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Collection.Bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Santosh
 */
public class CollectionBean {
    private Integer COLLECTION_ID;
    private Integer STUDENT_ID;
    private String BILL_NO;
    private Integer PAID_AMT;
    private Integer ENTRY_ID;
    private Date ENTRY_DATE;
    private Timestamp ENTRY_DATE_TIME;

    /**
     * @return the COLLECTION_ID
     */
    public Integer getCOLLECTION_ID() {
        return COLLECTION_ID;
    }

    /**
     * @param COLLECTION_ID the COLLECTION_ID to set
     */
    public void setCOLLECTION_ID(Integer COLLECTION_ID) {
        this.COLLECTION_ID = COLLECTION_ID;
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
     * @return the BILL_NO
     */
    public String getBILL_NO() {
        return BILL_NO;
    }

    /**
     * @param BILL_NO the BILL_NO to set
     */
    public void setBILL_NO(String BILL_NO) {
        this.BILL_NO = BILL_NO;
    }

    /**
     * @return the PAID_AMT
     */
    public Integer getPAID_AMT() {
        return PAID_AMT;
    }

    /**
     * @param PAID_AMT the PAID_AMT to set
     */
    public void setPAID_AMT(Integer PAID_AMT) {
        this.PAID_AMT = PAID_AMT;
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
