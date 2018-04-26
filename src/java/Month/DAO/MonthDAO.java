/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Month.DAO;

import Month.Bean.MonthBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface MonthDAO {
    public ArrayList getMonths();
    public MonthBean getMonthById(int MONTH_ID);
}
