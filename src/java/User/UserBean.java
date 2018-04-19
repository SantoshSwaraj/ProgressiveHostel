/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User;

import java.sql.Timestamp;

/**
 *
 * @author Santosh
 */
public class UserBean {
    private int USER_ID;
    private int EMPLOYEE_ID;
    private String EMP_NAME;
    private String MOBILE_NO;
    private String EMAIL;
    private String USERNAME;
    private String PASSWORD;
    private int USER_TYPE_ID;
    private int STATUS;
    private Timestamp ENTRY_DATE_TIME;

    /**
     * @return the USER_ID
     */
    public int getUSER_ID() {
        return USER_ID;
    }

    /**
     * @param USER_ID the USER_ID to set
     */
    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    /**
     * @return the EMPLOYEE_ID
     */
    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    /**
     * @param EMPLOYEE_ID the EMPLOYEE_ID to set
     */
    public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    /**
     * @return the EMP_NAME
     */
    public String getEMP_NAME() {
        return EMP_NAME;
    }

    /**
     * @param EMP_NAME the EMP_NAME to set
     */
    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    /**
     * @return the MOBILE_NO
     */
    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    /**
     * @param MOBILE_NO the MOBILE_NO to set
     */
    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    /**
     * @return the EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * @param EMAIL the EMAIL to set
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    /**
     * @return the USERNAME
     */
    public String getUSERNAME() {
        return USERNAME;
    }

    /**
     * @param USERNAME the USERNAME to set
     */
    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param PASSWORD the PASSWORD to set
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    /**
     * @return the USER_TYPE_ID
     */
    public int getUSER_TYPE_ID() {
        return USER_TYPE_ID;
    }

    /**
     * @param USER_TYPE_ID the USER_TYPE_ID to set
     */
    public void setUSER_TYPE_ID(int USER_TYPE_ID) {
        this.USER_TYPE_ID = USER_TYPE_ID;
    }

    /**
     * @return the STATUS
     */
    public int getSTATUS() {
        return STATUS;
    }

    /**
     * @param STATUS the STATUS to set
     */
    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
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
