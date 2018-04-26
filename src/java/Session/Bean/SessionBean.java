/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session.Bean;

/**
 *
 * @author Santosh Kushwaha
 */
public class SessionBean {

    private Integer SESSION_ID;
    private String SESSION;

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
     * @return the SESSION
     */
    public String getSESSION() {
        return SESSION;
    }

    /**
     * @param SESSION the SESSION to set
     */
    public void setSESSION(String SESSION) {
        this.SESSION = SESSION;
    }

}
