/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassHostelMonthlyFee.Bean;

import Classes.Bean.ClassBean;

/**
 *
 * @author Santosh Kushwaha
 */
public class ClassHostelMonthlyFeeBean {
    private Integer CLASS_HOSTEL_MONTHLY_FEE_ID;
    private Integer CLASS_ID;
    private Integer FEE;
    private ClassBean classBean;

    /**
     * @return the CLASS_HOSTEL_MONTHLY_FEE_ID
     */
    public Integer getCLASS_HOSTEL_MONTHLY_FEE_ID() {
        return CLASS_HOSTEL_MONTHLY_FEE_ID;
    }

    /**
     * @param CLASS_HOSTEL_MONTHLY_FEE_ID the CLASS_HOSTEL_MONTHLY_FEE_ID to set
     */
    public void setCLASS_HOSTEL_MONTHLY_FEE_ID(Integer CLASS_HOSTEL_MONTHLY_FEE_ID) {
        this.CLASS_HOSTEL_MONTHLY_FEE_ID = CLASS_HOSTEL_MONTHLY_FEE_ID;
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
     * @return the FEE
     */
    public Integer getFEE() {
        return FEE;
    }

    /**
     * @param FEE the FEE to set
     */
    public void setFEE(Integer FEE) {
        this.FEE = FEE;
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
    
}
