/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassSection.DAO;

import ClassSection.Bean.ClassSectionBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface ClassSectionDAO {
    public int addClassSection(ClassSectionBean classSectionBean);
    public ArrayList getClassSections();
    public ArrayList getSectionsByClassId(int CLASS_ID);
}
