package com.zhiye.dao;

import com.zhiye.common.bean.ZyDictionary;
import com.zhiye.common.bean.ZyDictionaryParams;
import java.util.List;
import java.util.Map;

public interface ZyDictionaryDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    void insert(ZyDictionary record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    int updateByPrimaryKey(ZyDictionary record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    int updateByPrimaryKeySelective(ZyDictionary record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    List selectByExample(ZyDictionaryParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    ZyDictionary selectByPrimaryKey(String name,String dictid);
    
    List selectByPrimaryKey(Map<String, Object> map);
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    ZyDictionary selectByPrimaryKey(Integer code);
    
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    int deleteByExample(ZyDictionaryParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    int deleteByPrimaryKey(Integer code);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    int countByExample(ZyDictionaryParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    int updateByExampleSelective(ZyDictionary record, ZyDictionaryParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_dictionary
     *
     * @abatorgenerated Thu Apr 12 15:12:08 CST 2012
     */
    int updateByExample(ZyDictionary record, ZyDictionaryParams example);
    List selectPaginationByPageNum(Map<String, Object> map) ;
    int countPaginationByPageNum(Map<String, Object> map) ;
}