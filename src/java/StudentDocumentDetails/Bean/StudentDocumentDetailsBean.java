/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StudentDocumentDetails.Bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Santosh Kushwaha
 */
public class StudentDocumentDetailsBean {
    private Integer STUDENT_DOCUMENT_DETAILS_ID;
    private Integer STUDENT_ID;
    private String STUDENT_PHOTO_DOC;
    private String STUDENT_AADHAR_DOC;
    private String STUDENT_SCHOOL_ID_DOC;
    private Integer ENTRY_ID;
    private Date ENTRY_DATE;
    private Timestamp ENTRY_DATE_TIME;

    /**
     * @return the STUDENT_DOCUMENT_DETAILS_ID
     */
    public Integer getSTUDENT_DOCUMENT_DETAILS_ID() {
        return STUDENT_DOCUMENT_DETAILS_ID;
    }

    /**
     * @param STUDENT_DOCUMENT_DETAILS_ID the STUDENT_DOCUMENT_DETAILS_ID to set
     */
    public void setSTUDENT_DOCUMENT_DETAILS_ID(Integer STUDENT_DOCUMENT_DETAILS_ID) {
        this.STUDENT_DOCUMENT_DETAILS_ID = STUDENT_DOCUMENT_DETAILS_ID;
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
     * @return the STUDENT_PHOTO_DOC
     */
    public String getSTUDENT_PHOTO_DOC() {
        return STUDENT_PHOTO_DOC;
    }

    /**
     * @param STUDENT_PHOTO_DOC the STUDENT_PHOTO_DOC to set
     */
    public void setSTUDENT_PHOTO_DOC(String STUDENT_PHOTO_DOC) {
        this.STUDENT_PHOTO_DOC = STUDENT_PHOTO_DOC;
    }

    /**
     * @return the STUDENT_AADHAR_DOC
     */
    public String getSTUDENT_AADHAR_DOC() {
        return STUDENT_AADHAR_DOC;
    }

    /**
     * @param STUDENT_AADHAR_DOC the STUDENT_AADHAR_DOC to set
     */
    public void setSTUDENT_AADHAR_DOC(String STUDENT_AADHAR_DOC) {
        this.STUDENT_AADHAR_DOC = STUDENT_AADHAR_DOC;
    }

    /**
     * @return the STUDENT_SCHOOL_ID_DOC
     */
    public String getSTUDENT_SCHOOL_ID_DOC() {
        return STUDENT_SCHOOL_ID_DOC;
    }

    /**
     * @param STUDENT_SCHOOL_ID_DOC the STUDENT_SCHOOL_ID_DOC to set
     */
    public void setSTUDENT_SCHOOL_ID_DOC(String STUDENT_SCHOOL_ID_DOC) {
        this.STUDENT_SCHOOL_ID_DOC = STUDENT_SCHOOL_ID_DOC;
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
