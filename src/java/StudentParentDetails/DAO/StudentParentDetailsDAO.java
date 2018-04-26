/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StudentParentDetails.DAO;

import StudentParentDetails.Bean.StudentParentDetailsBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface StudentParentDetailsDAO {
    public int addStudentParentDetails(StudentParentDetailsBean studentParentDetailsBean);
    public ArrayList getAllStudentParentDetails();
    
}
