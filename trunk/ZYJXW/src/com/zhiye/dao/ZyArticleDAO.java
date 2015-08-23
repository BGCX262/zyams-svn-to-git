package com.zhiye.dao;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyArticleParams;
import com.zhiye.common.bean.ZyArticleWithBLOBs;

public interface ZyArticleDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    void insert(ZyArticleWithBLOBs record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByPrimaryKey(ZyArticle record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByPrimaryKey(ZyArticleWithBLOBs record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByPrimaryKeySelective(ZyArticleWithBLOBs record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    List selectByParamsWithoutBLOBs(ZyArticleParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    List selectByParamsWithBLOBs(ZyArticleParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    ZyArticleWithBLOBs selectByPrimaryKey(Long articleId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int deleteByParams(ZyArticleParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int deleteByPrimaryKey(Long articleId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int countByParams(ZyArticleParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByParamsSelective(ZyArticleWithBLOBs record, ZyArticleParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByParams(ZyArticleWithBLOBs record, ZyArticleParams example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByParams(ZyArticle record, ZyArticleParams example);
    
     List selectPaginationByPageNum(Map<String, Object> map) ;
     int countPaginationByPageNum(Map<String, Object> map) ;
     
     List searchForPagerWithRoleId(Map<String, Object> map) ;
     int countSearchPagerWithRoleId(Map<String, Object> map) ;
     
     
     List selectPaginationByTypeId(Map<String, Object> map) ;
     int countPaginationByTypeId(Map<String, Object> map) ;
}