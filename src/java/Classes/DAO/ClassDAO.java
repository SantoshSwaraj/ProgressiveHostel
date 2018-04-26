/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes.DAO;
import Classes.Bean.ClassBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface ClassDAO {
    public int addClass(ClassBean classBean);
    public ArrayList getClasses();
    public ClassBean getClassById(int CLASS_ID);
    
}
