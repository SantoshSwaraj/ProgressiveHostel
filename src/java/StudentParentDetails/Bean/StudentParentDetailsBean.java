/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentParentDetails.Bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentParentDetailsBean {

    private Integer STUDENT_PARENT_DETAILS_ID;
    private Integer STUDENT_ID;
    private String STUDENT_FATHER_NAME;
    private String STUDENT_FATHER_MOBILE_NUMBER;
    private String STUDENT_FATHER_OCCUPATION;
    private String STUDENT_MOTHER_NAME;
    private String STUDENT_MOTHER_MOBILE_NUMBER;
    private String STUDENT_MOTHER_OCCUPATION;
    private String STUDENT_GUARDIAN_NAME;
    private String STUDENT_GUARDIAN_MOBILE;
    private Integer ENTRY_ID;
    private Date ENTRY_DATE;
    private Timestamp ENTRY_DATE_TIME;

    /**
     * @return the STUDENT_PARENT_DETAILS_ID
     */
    public Integer getSTUDENT_PARENT_DETAILS_ID() {
        return STUDENT_PARENT_DETAILS_ID;
    }

    /**
     * @param STUDENT_PARENT_DETAILS_ID the STUDENT_PARENT_DETAILS_ID to set
     */
    public void setSTUDENT_PARENT_DETAILS_ID(Integer STUDENT_PARENT_DETAILS_ID) {
        this.STUDENT_PARENT_DETAILS_ID = STUDENT_PARENT_DETAILS_ID;
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
     * @return the STUDENT_FATHER_NAME
     */
    public String getSTUDENT_FATHER_NAME() {
        return STUDENT_FATHER_NAME;
    }

    /**
     * @param STUDENT_FATHER_NAME the STUDENT_FATHER_NAME to set
     */
    public void setSTUDENT_FATHER_NAME(String STUDENT_FATHER_NAME) {
        this.STUDENT_FATHER_NAME = STUDENT_FATHER_NAME;
    }

    /**
     * @return the STUDENT_FATHER_MOBILE_NUMBER
     */
    public String getSTUDENT_FATHER_MOBILE_NUMBER() {
        return STUDENT_FATHER_MOBILE_NUMBER;
    }

    /**
     * @param STUDENT_FATHER_MOBILE_NUMBER the STUDENT_FATHER_MOBILE_NUMBER to
     * set
     */
    public void setSTUDENT_FATHER_MOBILE_NUMBER(String STUDENT_FATHER_MOBILE_NUMBER) {
        this.STUDENT_FATHER_MOBILE_NUMBER = STUDENT_FATHER_MOBILE_NUMBER;
    }

    /**
     * @return the STUDENT_FATHER_OCCUPATION
     */
    public String getSTUDENT_FATHER_OCCUPATION() {
        return STUDENT_FATHER_OCCUPATION;
    }

    /**
     * @param STUDENT_FATHER_OCCUPATION the STUDENT_FATHER_OCCUPATION to set
     */
    public void setSTUDENT_FATHER_OCCUPATION(String STUDENT_FATHER_OCCUPATION) {
        this.STUDENT_FATHER_OCCUPATION = STUDENT_FATHER_OCCUPATION;
    }

    /**
     * @return the STUDENT_MOTHER_NAME
     */
    public String getSTUDENT_MOTHER_NAME() {
        return STUDENT_MOTHER_NAME;
    }

    /**
     * @param STUDENT_MOTHER_NAME the STUDENT_MOTHER_NAME to set
     */
    public void setSTUDENT_MOTHER_NAME(String STUDENT_MOTHER_NAME) {
        this.STUDENT_MOTHER_NAME = STUDENT_MOTHER_NAME;
    }

    /**
     * @return the STUDENT_MOTHER_MOBILE_NUMBER
     */
    public String getSTUDENT_MOTHER_MOBILE_NUMBER() {
        return STUDENT_MOTHER_MOBILE_NUMBER;
    }

    /**
     * @param STUDENT_MOTHER_MOBILE_NUMBER the STUDENT_MOTHER_MOBILE_NUMBER to
     * set
     */
    public void setSTUDENT_MOTHER_MOBILE_NUMBER(String STUDENT_MOTHER_MOBILE_NUMBER) {
        this.STUDENT_MOTHER_MOBILE_NUMBER = STUDENT_MOTHER_MOBILE_NUMBER;
    }

    /**
     * @return the STUDENT_MOTHER_OCCUPATION
     */
    public String getSTUDENT_MOTHER_OCCUPATION() {
        return STUDENT_MOTHER_OCCUPATION;
    }

    /**
     * @param STUDENT_MOTHER_OCCUPATION the STUDENT_MOTHER_OCCUPATION to set
     */
    public void setSTUDENT_MOTHER_OCCUPATION(String STUDENT_MOTHER_OCCUPATION) {
        this.STUDENT_MOTHER_OCCUPATION = STUDENT_MOTHER_OCCUPATION;
    }

    /**
     * @return the STUDENT_GUARDIAN_NAME
     */
    public String getSTUDENT_GUARDIAN_NAME() {
        return STUDENT_GUARDIAN_NAME;
    }

    /**
     * @param STUDENT_GUARDIAN_NAME the STUDENT_GUARDIAN_NAME to set
     */
    public void setSTUDENT_GUARDIAN_NAME(String STUDENT_GUARDIAN_NAME) {
        this.STUDENT_GUARDIAN_NAME = STUDENT_GUARDIAN_NAME;
    }

    /**
     * @return the STUDENT_GUARDIAN_MOBILE
     */
    public String getSTUDENT_GUARDIAN_MOBILE() {
        return STUDENT_GUARDIAN_MOBILE;
    }

    /**
     * @param STUDENT_GUARDIAN_MOBILE the STUDENT_GUARDIAN_MOBILE to set
     */
    public void setSTUDENT_GUARDIAN_MOBILE(String STUDENT_GUARDIAN_MOBILE) {
        this.STUDENT_GUARDIAN_MOBILE = STUDENT_GUARDIAN_MOBILE;
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
