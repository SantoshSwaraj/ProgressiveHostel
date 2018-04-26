/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassHostelMonthlyFee.DAO;

import ClassHostelMonthlyFee.Bean.ClassHostelMonthlyFeeBean;
import ClassSection.Bean.ClassSectionBean;
import java.util.ArrayList;

/**
 *
 * @author mishra
 */
public interface ClassHostelMonthlyFeeDAO {
    public int addClassHostelMonthlyFee(ClassHostelMonthlyFeeBean classHostelMonthlyFeeBean);
    public ArrayList getClassHostelMonthlyFees();
    public ClassHostelMonthlyFeeBean getClassHostelMonthlyFeeByClassId(int CLASS_ID);
    
}
