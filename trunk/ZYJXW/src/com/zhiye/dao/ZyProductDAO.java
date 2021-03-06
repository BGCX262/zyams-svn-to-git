package com.zhiye.dao;

import com.zhiye.common.bean.ZyProduct;
import com.zhiye.common.bean.ZyProductParams;
import java.util.List;
import java.util.Map;

public interface ZyProductDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    void insert(ZyProduct record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    int updateByPrimaryKey(ZyProduct record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    int updateByPrimaryKeySelective(ZyProduct record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    List selectByExample(ZyProductParams example);
    List selectByExample();
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    ZyProduct selectByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    int deleteByExample(ZyProductParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    int countByExample(ZyProductParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    int updateByExampleSelective(ZyProduct record, ZyProductParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_product
     *
     * @abatorgenerated Tue Apr 10 10:29:43 CST 2012
     */
    int updateByExample(ZyProduct record, ZyProductParams example);
    List selectByPrimaryKey(Map<String, Object> map);
    List selectPaginationByPageNum(Map<String, Object> map) ;
    int countPaginationByPageNum(Map<String, Object> map) ;
}