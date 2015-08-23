package com.zhiye.dao;

import com.zhiye.common.bean.ZyDictclass;
import com.zhiye.common.bean.ZyDictclassParams;
import java.util.List;

public interface ZyDictclassDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    void insert(ZyDictclass record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    int updateByPrimaryKey(ZyDictclass record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    int updateByPrimaryKeySelective(ZyDictclass record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    List selectByExample(ZyDictclassParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    ZyDictclass selectByPrimaryKey(String dictid);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    int deleteByExample(ZyDictclassParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    int deleteByPrimaryKey(String dictid);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    int countByExample(ZyDictclassParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    int updateByExampleSelective(ZyDictclass record, ZyDictclassParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictclass
     *
     * @abatorgenerated Thu Apr 12 16:35:35 CST 2012
     */
    int updateByExample(ZyDictclass record, ZyDictclassParams example);
}