/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StudentAddressDetails.Bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentAddressDetailsBean {
    private Integer STUDENT_ADDRESS_DETAILS_ID;
    private Integer STUDENT_ID;
    private String STUDENT_C_ADDRESS;
    private String STUDENT_C_STATE;
    private String STUDENT_C_CITY;
    private String STUDENT_C_PIN_CODE;
    private String STUDENT_P_ADDRESS;
    private String STUDENT_P_STATE;
    private String STUDENT_P_CITY;
    private String STUDENT_P_PIN_CODE;
    private Integer ENTRY_ID;
    private Date ENTRY_DATE;
    private Timestamp ENTRY_DATE_TIME;

    /**
     * @return the STUDENT_ADDRESS_DETAILS_ID
     */
    public Integer getSTUDENT_ADDRESS_DETAILS_ID() {
        return STUDENT_ADDRESS_DETAILS_ID;
    }

    /**
     * @param STUDENT_ADDRESS_DETAILS_ID the STUDENT_ADDRESS_DETAILS_ID to set
     */
    public void setSTUDENT_ADDRESS_DETAILS_ID(Integer STUDENT_ADDRESS_DETAILS_ID) {
        this.STUDENT_ADDRESS_DETAILS_ID = STUDENT_ADDRESS_DETAILS_ID;
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
     * @return the STUDENT_C_ADDRESS
     */
    public String getSTUDENT_C_ADDRESS() {
        return STUDENT_C_ADDRESS;
    }

    /**
     * @param STUDENT_C_ADDRESS the STUDENT_C_ADDRESS to set
     */
    public void setSTUDENT_C_ADDRESS(String STUDENT_C_ADDRESS) {
        this.STUDENT_C_ADDRESS = STUDENT_C_ADDRESS;
    }

    /**
     * @return the STUDENT_C_STATE
     */
    public String getSTUDENT_C_STATE() {
        return STUDENT_C_STATE;
    }

    /**
     * @param STUDENT_C_STATE the STUDENT_C_STATE to set
     */
    public void setSTUDENT_C_STATE(String STUDENT_C_STATE) {
        this.STUDENT_C_STATE = STUDENT_C_STATE;
    }

    /**
     * @return the STUDENT_C_CITY
     */
    public String getSTUDENT_C_CITY() {
        return STUDENT_C_CITY;
    }

    /**
     * @param STUDENT_C_CITY the STUDENT_C_CITY to set
     */
    public void setSTUDENT_C_CITY(String STUDENT_C_CITY) {
        this.STUDENT_C_CITY = STUDENT_C_CITY;
    }

    /**
     * @return the STUDENT_C_PIN_CODE
     */
    public String getSTUDENT_C_PIN_CODE() {
        return STUDENT_C_PIN_CODE;
    }

    /**
     * @param STUDENT_C_PIN_CODE the STUDENT_C_PIN_CODE to set
     */
    public void setSTUDENT_C_PIN_CODE(String STUDENT_C_PIN_CODE) {
        this.STUDENT_C_PIN_CODE = STUDENT_C_PIN_CODE;
    }

    /**
     * @return the STUDENT_P_ADDRESS
     */
    public String getSTUDENT_P_ADDRESS() {
        return STUDENT_P_ADDRESS;
    }

    /**
     * @param STUDENT_P_ADDRESS the STUDENT_P_ADDRESS to set
     */
    public void setSTUDENT_P_ADDRESS(String STUDENT_P_ADDRESS) {
        this.STUDENT_P_ADDRESS = STUDENT_P_ADDRESS;
    }

    /**
     * @return the STUDENT_P_STATE
     */
    public String getSTUDENT_P_STATE() {
        return STUDENT_P_STATE;
    }

    /**
     * @param STUDENT_P_STATE the STUDENT_P_STATE to set
     */
    public void setSTUDENT_P_STATE(String STUDENT_P_STATE) {
        this.STUDENT_P_STATE = STUDENT_P_STATE;
    }

    /**
     * @return the STUDENT_P_CITY
     */
    public String getSTUDENT_P_CITY() {
        return STUDENT_P_CITY;
    }

    /**
     * @param STUDENT_P_CITY the STUDENT_P_CITY to set
     */
    public void setSTUDENT_P_CITY(String STUDENT_P_CITY) {
        this.STUDENT_P_CITY = STUDENT_P_CITY;
    }

    /**
     * @return the STUDENT_P_PIN_CODE
     */
    public String getSTUDENT_P_PIN_CODE() {
        return STUDENT_P_PIN_CODE;
    }

    /**
     * @param STUDENT_P_PIN_CODE the STUDENT_P_PIN_CODE to set
     */
    public void setSTUDENT_P_PIN_CODE(String STUDENT_P_PIN_CODE) {
        this.STUDENT_P_PIN_CODE = STUDENT_P_PIN_CODE;
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
