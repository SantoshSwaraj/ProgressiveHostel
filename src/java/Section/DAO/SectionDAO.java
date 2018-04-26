/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Section.DAO;

import Section.Bean.SectionBean;
import java.util.ArrayList;

/**
 *
 * @author Santosh Kushwaha
 */
public interface SectionDAO {
    public int addSection(SectionBean sectionBean);
    public ArrayList getSections();
    public SectionBean getSectionById(int SECTION_ID);
}
