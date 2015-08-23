package com.zhiye.dao;

import java.util.List;

import com.zhiye.common.bean.ZySite;

public interface ZySiteDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    void insert(ZySite record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int updateByPrimaryKey(ZySite record);
    
    long countAllRecords();

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    ZySite selectByPrimaryKey(Long articleId);
    
    List<ZySite> selectByIP(String ip);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_article
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    int deleteByParams(long example);

}