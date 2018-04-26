/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OneTimeCharges.DAO;

import OneTimeCharges.Bean.OneTimeChargeBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface OneTimeChargesDAO {
    public int addOneTimeCharges(OneTimeChargeBean oneTimeChargeBean);
    public ArrayList getOneTimeCharges();
    
}
