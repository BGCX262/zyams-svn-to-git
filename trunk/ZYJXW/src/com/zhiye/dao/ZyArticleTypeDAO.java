package com.zhiye.dao;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyArticleTypeParams;

public interface ZyArticleTypeDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    void insert(ZyArticleType record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByPrimaryKey(ZyArticleType record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByPrimaryKeySelective(ZyArticleType record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    List selectByParams(ZyArticleTypeParams example);
    
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    List selectPaginationByPageNum(Map<String,Object> map);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    ZyArticleType selectByPrimaryKey(Integer typeId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int deleteByParams(ZyArticleTypeParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int deleteByPrimaryKey(Integer typeId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int countByParams(ZyArticleTypeParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByParamsSelective(ZyArticleType record, ZyArticleTypeParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article_type
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByParams(ZyArticleType record, ZyArticleTypeParams example);
}