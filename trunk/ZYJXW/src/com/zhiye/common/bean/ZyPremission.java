package com.zhiye.common.bean;

import java.io.Serializable;

public class ZyPremission implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column zy_premission.premission_id
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    private Integer premissionId;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column zy_premission.section_id
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    private Integer sectionId;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column zy_premission.premission_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    private String premissionType;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column zy_premission.remarks
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    private String remarks;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column zy_premission.premission_id
     *
     * @return the value of zy_premission.premission_id
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public Integer getPremissionId() {
        return premissionId;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column zy_premission.premission_id
     *
     * @param premissionId the value for zy_premission.premission_id
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public void setPremissionId(Integer premissionId) {
        this.premissionId = premissionId;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column zy_premission.section_id
     *
     * @return the value of zy_premission.section_id
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column zy_premission.section_id
     *
     * @param sectionId the value for zy_premission.section_id
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column zy_premission.premission_type
     *
     * @return the value of zy_premission.premission_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public String getPremissionType() {
        return premissionType;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column zy_premission.premission_type
     *
     * @param premissionType the value for zy_premission.premission_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public void setPremissionType(String premissionType) {
        this.premissionType = premissionType;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column zy_premission.remarks
     *
     * @return the value of zy_premission.remarks
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column zy_premission.remarks
     *
     * @param remarks the value for zy_premission.remarks
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}