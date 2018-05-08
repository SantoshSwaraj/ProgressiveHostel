/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StudentMaster.Bean;

import Classes.Bean.ClassBean;
import Section.Bean.SectionBean;
import Session.Bean.SessionBean;
import StudentAddressDetails.Bean.StudentAddressDetailsBean;
import StudentDocumentDetails.Bean.StudentDocumentDetailsBean;
import StudentOneTimeChargeDetails.Bean.StudentOneTimeChargeDetailsBean;
import StudentParentDetails.Bean.StudentParentDetailsBean;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Santosh
 */
public class StudentMasterBean {
   private Integer STUDENT_ID;
   private String STUDENT_NAME;
   private Integer SESSION_ID;
   private Integer CLASS_ID;
   private Integer SECTION_ID;
   private Integer STUDENT_ROLL_NO;
   private Date STUDENT_DOB;
   private String ADMISSION_NO;
   private Integer IS_ACTIVE;
   private Integer ENTRY_ID;
   private Date ENTRY_DATE;
   private Timestamp ENTRY_DATE_TIME;
   private SessionBean sessionBean;
   private ClassBean classBean;
   private SectionBean sectionBean;
   private StudentParentDetailsBean studentParentDetailsBean;
   private StudentAddressDetailsBean studentAddressDetailsBean;
   private StudentDocumentDetailsBean studentDocumentDetailsBean;
   private StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean;

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
     * @return the STUDENT_NAME
     */
    public String getSTUDENT_NAME() {
        return STUDENT_NAME;
    }

    /**
     * @param STUDENT_NAME the STUDENT_NAME to set
     */
    public void setSTUDENT_NAME(String STUDENT_NAME) {
        this.STUDENT_NAME = STUDENT_NAME;
    }

    /**
     * @return the SESSION_ID
     */
    public Integer getSESSION_ID() {
        return SESSION_ID;
    }

    /**
     * @param SESSION_ID the SESSION_ID to set
     */
    public void setSESSION_ID(Integer SESSION_ID) {
        this.SESSION_ID = SESSION_ID;
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
     * @return the STUDENT_ROLL_NO
     */
    public Integer getSTUDENT_ROLL_NO() {
        return STUDENT_ROLL_NO;
    }

    /**
     * @param STUDENT_ROLL_NO the STUDENT_ROLL_NO to set
     */
    public void setSTUDENT_ROLL_NO(Integer STUDENT_ROLL_NO) {
        this.STUDENT_ROLL_NO = STUDENT_ROLL_NO;
    }

    /**
     * @return the STUDENT_DOB
     */
    public Date getSTUDENT_DOB() {
        return STUDENT_DOB;
    }

    /**
     * @param STUDENT_DOB the STUDENT_DOB to set
     */
    public void setSTUDENT_DOB(Date STUDENT_DOB) {
        this.STUDENT_DOB = STUDENT_DOB;
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
     * @return the IS_ACTIVE
     */
    public Integer getIS_ACTIVE() {
        return IS_ACTIVE;
    }

    /**
     * @param IS_ACTIVE the IS_ACTIVE to set
     */
    public void setIS_ACTIVE(Integer IS_ACTIVE) {
        this.IS_ACTIVE = IS_ACTIVE;
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

    /**
     * @return the sessionBean
     */
    public SessionBean getSessionBean() {
        return sessionBean;
    }

    /**
     * @param sessionBean the sessionBean to set
     */
    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    /**
     * @return the classBean
     */
    public ClassBean getClassBean() {
        return classBean;
    }

    /**
     * @param classBean the classBean to set
     */
    public void setClassBean(ClassBean classBean) {
        this.classBean = classBean;
    }

    /**
     * @return the sectionBean
     */
    public SectionBean getSectionBean() {
        return sectionBean;
    }

    /**
     * @param sectionBean the sectionBean to set
     */
    public void setSectionBean(SectionBean sectionBean) {
        this.sectionBean = sectionBean;
    }

    /**
     * @return the studentParentDetailsBean
     */
    public StudentParentDetailsBean getStudentParentDetailsBean() {
        return studentParentDetailsBean;
    }

    /**
     * @param studentParentDetailsBean the studentParentDetailsBean to set
     */
    public void setStudentParentDetailsBean(StudentParentDetailsBean studentParentDetailsBean) {
        this.studentParentDetailsBean = studentParentDetailsBean;
    }

    /**
     * @return the studentAddressDetailsBean
     */
    public StudentAddressDetailsBean getStudentAddressDetailsBean() {
        return studentAddressDetailsBean;
    }

    /**
     * @param studentAddressDetailsBean the studentAddressDetailsBean to set
     */
    public void setStudentAddressDetailsBean(StudentAddressDetailsBean studentAddressDetailsBean) {
        this.studentAddressDetailsBean = studentAddressDetailsBean;
    }

    /**
     * @return the studentDocumentDetailsBean
     */
    public StudentDocumentDetailsBean getStudentDocumentDetailsBean() {
        return studentDocumentDetailsBean;
    }

    /**
     * @param studentDocumentDetailsBean the studentDocumentDetailsBean to set
     */
    public void setStudentDocumentDetailsBean(StudentDocumentDetailsBean studentDocumentDetailsBean) {
        this.studentDocumentDetailsBean = studentDocumentDetailsBean;
    }

    /**
     * @return the studentOneTimeChargeDetailsBean
     */
    public StudentOneTimeChargeDetailsBean getStudentOneTimeChargeDetailsBean() {
        return studentOneTimeChargeDetailsBean;
    }

    /**
     * @param studentOneTimeChargeDetailsBean the studentOneTimeChargeDetailsBean to set
     */
    public void setStudentOneTimeChargeDetailsBean(StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean) {
        this.studentOneTimeChargeDetailsBean = studentOneTimeChargeDetailsBean;
    }
   

   

    
}
