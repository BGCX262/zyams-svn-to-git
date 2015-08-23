package com.zhiye.dao;

import java.util.List;

import com.zhiye.common.bean.ZyCompany;
import com.zhiye.common.bean.ZyCompanyParams;

public interface ZyCompanyDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int insert(ZyCompany record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int updateByPrimaryKey(ZyCompany record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int updateByPrimaryKeySelective(ZyCompany record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    List selectByParams(ZyCompanyParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    ZyCompany selectByPrimaryKey(Integer companyId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int deleteByParams(ZyCompanyParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int deleteByPrimaryKey(Integer companyId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int countByParams(ZyCompanyParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int updateByParamsSelective(ZyCompany record, ZyCompanyParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_company
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    int updateByParams(ZyCompany record, ZyCompanyParams example);
}