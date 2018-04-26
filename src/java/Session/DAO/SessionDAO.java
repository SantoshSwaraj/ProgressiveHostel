/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Session.DAO;

import Session.Bean.SessionBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface SessionDAO {
    public ArrayList getSessions();
    public SessionBean getSessionById(int SESSION_ID);
}
