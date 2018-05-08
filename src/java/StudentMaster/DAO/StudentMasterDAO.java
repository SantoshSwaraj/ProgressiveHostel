/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StudentMaster.DAO;

import Session.Bean.SessionBean;
import StudentMaster.Bean.StudentMasterBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Santosh Kushwaha
 */
public interface StudentMasterDAO {
    public int addStudentMaster(StudentMasterBean studentMasterBean);
    public ArrayList getAllStudentMasterDetails();
    public StudentMasterBean getStudentAllDetailsById(int STUDENT_ID);
    public StudentMasterBean getStudentMasterDetailsById(int STUDENT_ID);
    public StudentMasterBean getStudentMasterDetailsByAdmissionNo(String ADMISSION_NO);
    public String generateAdmissionNo(SessionBean sessionBean);
    public ArrayList getStudentMasterDetailsByFilter(StudentMasterBean studentMasterBean, Date START_DATE, Date END_DATE);
    public int countOfRegisteredStudents();
}
