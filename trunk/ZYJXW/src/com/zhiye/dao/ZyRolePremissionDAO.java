package com.zhiye.dao;

import java.util.List;

import com.zhiye.common.bean.ZyRolePremission;
import com.zhiye.common.bean.ZyRolePremissionParams;

public interface ZyRolePremissionDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    void insert(ZyRolePremission record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    List selectByParams(ZyRolePremissionParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int deleteByParams(ZyRolePremissionParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int countByParams(ZyRolePremissionParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByParamsSelective(ZyRolePremission record, ZyRolePremissionParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByParams(ZyRolePremission record, ZyRolePremissionParams example);
}