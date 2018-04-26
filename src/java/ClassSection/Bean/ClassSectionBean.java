/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassSection.Bean;

import Classes.Bean.ClassBean;
import Section.Bean.SectionBean;

/**
 *
 * @author mishra
 */
public class ClassSectionBean {

    private Integer CLASS_SECTION_ID;
    private Integer CLASS_ID;
    private Integer SECTION_ID;
    private ClassBean classBean;
    private SectionBean sectionBean;

    /**
     * @return the CLASS_SECTION_ID
     */
    public Integer getCLASS_SECTION_ID() {
        return CLASS_SECTION_ID;
    }

    /**
     * @param CLASS_SECTION_ID the CLASS_SECTION_ID to set
     */
    public void setCLASS_SECTION_ID(Integer CLASS_SECTION_ID) {
        this.CLASS_SECTION_ID = CLASS_SECTION_ID;
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
     * @return the SECTION_ID
     */
    public Integer getSECTION_ID() {
        return SECTION_ID;
    }

    /**
     * @param SECTION_ID the SECTION_ID to set
     */
    public void setSECTION_ID(Integer SECTION_ID) {
        this.SECTION_ID = SECTION_ID;
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

    /**
     * @return the sectionBean
     */
    public SectionBean getSectionBean() {
        return sectionBean;
    }

    /**
     * @param sectionBean the sectionBean to set
     */
    public void setSectionBean(SectionBean sectionBean) {
        this.sectionBean = sectionBean;
    }

}
