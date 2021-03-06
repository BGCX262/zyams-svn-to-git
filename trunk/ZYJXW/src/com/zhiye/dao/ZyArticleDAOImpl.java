package com.zhiye.dao;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyArticleParams;
import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyArticleWithBLOBs;

public class ZyArticleDAOImpl extends CommonDAO implements ZyArticleDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public ZyArticleDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public void insert(ZyArticleWithBLOBs record) {
		getSqlMapClientTemplate().insert("zy_article.insert", record);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int updateByPrimaryKey(ZyArticle record) {
		int rows = getSqlMapClientTemplate().update(
				"zy_article.updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int updateByPrimaryKey(ZyArticleWithBLOBs record) {
		int rows = getSqlMapClientTemplate().update(
				"zy_article.updateByPrimaryKeyWithBLOBs", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int updateByPrimaryKeySelective(ZyArticleWithBLOBs record) {
		int rows = getSqlMapClientTemplate().update(
				"zy_article.updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public List selectByParamsWithoutBLOBs(ZyArticleParams example) {
		List list = getSqlMapClientTemplate().queryForList(
				"zy_article.selectByParams", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public List selectByParamsWithBLOBs(ZyArticleParams example) {
		List list = getSqlMapClientTemplate().queryForList(
				"zy_article.selectByParamsWithBLOBs", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public ZyArticleWithBLOBs selectByPrimaryKey(Long articleId) {
		ZyArticle key = new ZyArticle();
		key.setArticleId(articleId);
		ZyArticleWithBLOBs record = (ZyArticleWithBLOBs) getSqlMapClientTemplate()
				.queryForObject("zy_article.selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int deleteByParams(ZyArticleParams example) {
		int rows = getSqlMapClientTemplate().delete(
				"zy_article.deleteByParams", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int deleteByPrimaryKey(Long articleId) {
		ZyArticle key = new ZyArticle();
		key.setArticleId(articleId);
		int rows = getSqlMapClientTemplate().delete(
				"zy_article.deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int countByParams(ZyArticleParams example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"zy_article.countByParams", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int updateByParamsSelective(ZyArticleWithBLOBs record,
			ZyArticleParams example) {
		UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"zy_article.updateByParamsSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int updateByParams(ZyArticleWithBLOBs record, ZyArticleParams example) {
		UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"zy_article.updateByParamsWithBLOBs", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	public int updateByParams(ZyArticle record, ZyArticleParams example) {
		UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"zy_article.updateByParams", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to
	 * the database table zy_article
	 * 
	 * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
	 */
	private static class UpdateByParamsParms extends ZyArticleParams {
		private Object record;

		public UpdateByParamsParms(Object record, ZyArticleParams example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	/**
	 * 根据MAP进行分页
	 */
	@SuppressWarnings("unchecked")
	public List selectPaginationByPageNum(Map<String, Object> map) {
		String m = "selectPaginationByPageNum";
		List<ZyArticle> articles = null;
		if (map != null) {
			articles = getSqlMapClientTemplate().queryForList(
					"zy_article.selectPaginationByPageNum", map);
		} else {
			return null;
		}
		return articles;
	}

	public int countPaginationByPageNum(Map<String, Object> map) {
		String m = "countPaginationByPageNum";
		int result = 0;
		if (map != null) {
			result = (Integer) getSqlMapClientTemplate().queryForObject(
					"zy_article.countPaginationByPageNum", map);
		} else {
			return 0;
		}
		return result;
	}

	public int countPaginationByTypeId(Map<String, Object> map) {
		String m = "countPaginationByTypeId";
		int result = 0;
		if (map != null) {
			result = (Integer) getSqlMapClientTemplate().queryForObject(
					"zy_article.countPaginationByTypeId", map);
		} else {
			return 0;
		}
		return result;
	}

	public List selectPaginationByTypeId(Map<String, Object> map) {
		String m = "selectPaginationByTypeId";
		List<ZyArticle> articles = null;
		if (map != null) {
			articles = getSqlMapClientTemplate().queryForList(
					"zy_article.selectPaginationByTypeId", map);
		} else {
			return null;
		}
		return articles;
	}

	public int countSearchPagerWithRoleId(Map<String, Object> map) {
		String m = "countSearchPagerWithRoleId";
		int result = 0;
		if (map != null) {
			result = (Integer) getSqlMapClientTemplate().queryForObject(
					"zy_article.countSearchPagerWithRoleId", map);
		} else {
			return 0;
		}
		return result;
	}

	public List searchForPagerWithRoleId(Map<String, Object> map) {
		String m = "searchForPagerWithRoleId";
		List<ZyArticle> articles = null;
		if (map != null) {
			articles = getSqlMapClientTemplate().queryForList(
					"zy_article.searchForPagerWithRoleId", map);
		} else {
			return null;
		}
		return articles;
	}
}