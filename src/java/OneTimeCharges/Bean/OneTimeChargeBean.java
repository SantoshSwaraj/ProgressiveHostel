/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OneTimeCharges.Bean;

/**
 *
 * @author Santosh Kushwaha
 */
public class OneTimeChargeBean {
    private Integer ONE_TIME_CHARGE_ID;
    private String CHARGE_NAME;
    private Integer CHARGE_AMOUNT;

    /**
     * @return the ONE_TIME_CHARGE_ID
     */
    public Integer getONE_TIME_CHARGE_ID() {
        return ONE_TIME_CHARGE_ID;
    }

    /**
     * @param ONE_TIME_CHARGE_ID the ONE_TIME_CHARGE_ID to set
     */
    public void setONE_TIME_CHARGE_ID(Integer ONE_TIME_CHARGE_ID) {
        this.ONE_TIME_CHARGE_ID = ONE_TIME_CHARGE_ID;
    }

    /**
     * @return the CHARGE_NAME
     */
    public String getCHARGE_NAME() {
        return CHARGE_NAME;
    }

    /**
     * @param CHARGE_NAME the CHARGE_NAME to set
     */
    public void setCHARGE_NAME(String CHARGE_NAME) {
        this.CHARGE_NAME = CHARGE_NAME;
    }

    /**
     * @return the CHARGE_AMOUNT
     */
    public Integer getCHARGE_AMOUNT() {
        return CHARGE_AMOUNT;
    }

    /**
     * @param CHARGE_AMOUNT the CHARGE_AMOUNT to set
     */
    public void setCHARGE_AMOUNT(Integer CHARGE_AMOUNT) {
        this.CHARGE_AMOUNT = CHARGE_AMOUNT;
    }
    
}

