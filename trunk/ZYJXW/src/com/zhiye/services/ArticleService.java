package com.zhiye.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyArticleParams;
import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyArticleTypeParams;
import com.zhiye.common.bean.ZyArticleWithBLOBs;
import com.zhiye.dao.ZyArticleDAO;
import com.zhiye.dao.ZyArticleTypeDAO;

public class ArticleService extends CommonService {
	private ZyArticleDAO articleDao;

	private ZyArticleTypeDAO articleTypeDao;

	private List<Integer> ids = new ArrayList<Integer>();

	public ZyArticleTypeDAO getArticleTypeDao() {
		return articleTypeDao;
	}

	public void setArticleTypeDao(ZyArticleTypeDAO articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}

	public ZyArticleDAO getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ZyArticleDAO articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * 添加文章
	 * 
	 */
	public void addArticle(ZyArticleWithBLOBs article) throws ServiceException {
		String method = "addArticle";
		if (article != null) {
			try {
				article.setClick(10);
				articleDao.insert(article);
			} catch (Exception e) {
				error(method, "add article dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add article successed! with article id="
				+ article.getArticleId());
	}

	/**
	 * 更新文章
	 * 
	 * @param article
	 * @return
	 */
	public int updateArticle(ZyArticleWithBLOBs article)
			throws ServiceException {
		String method = "updateArticle";
		int result = 0;
		if (null != article) {
			try {
				result = articleDao.updateByPrimaryKey(article);
			} catch (Exception e) {
				error(method, "update article DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update article success with articleid="
				+ article.getArticleId());
		return result;
	}

	/**
	 * 根据主键ID 查询 ARTICLE
	 * 
	 * @param articleId
	 * @return
	 */
	public ZyArticle findArticleById(long articleId) throws ServiceException {
		String method = "findArticleById";
		ZyArticle resultArticle = null;
		if (articleId > 0) {
			try {
				resultArticle = articleDao.selectByPrimaryKey(articleId);
			} catch (Exception e) {
				error(method, "find article by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find article success by id =" + articleId);

		if (resultArticle != null) {
			resultArticle.setClick(resultArticle.getClick() + 1);
			updateArticle((ZyArticleWithBLOBs) resultArticle);
		}
		return resultArticle;
	}

	/**
	 * 根据主键ID删除文章
	 * 
	 * @param articleId
	 * @return
	 */
	public int removeArticleById(long articleId) throws ServiceException {
		String method = "removeArticleById";
		int result = 0;
		if (articleId > 0) {
			try {
				result = articleDao.deleteByPrimaryKey(articleId);
			} catch (Exception e) {
				error(method, "delete article by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed article by id=" + articleId);
		return result;
	}

	/**
	 * 批量查询 获得ARTICLE,支持大文本
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticleWithBLOBs> findArticleListWithBLOB(
			ZyArticleParams params) throws ServiceException {
		String method = "findArticleList";
		List<ZyArticleWithBLOBs> articles = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			articles = articleDao.selectByParamsWithBLOBs(params);
		} catch (Exception e) {
			error(method, "find article by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query articles success by params=" + params.toString());

		return articles;
	}

	/**
	 * 批量查询 获得ARTICLE,不支持大文本
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticle> findArticleListWithOutBLOB(ZyArticleParams params)
			throws ServiceException {
		String method = "findArticleList";
		List<ZyArticle> articles = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			articles = articleDao.selectByParamsWithoutBLOBs(params);
		} catch (Exception e) {
			error(method, "find article by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query articles success by params=" + params.toString());

		return articles;
	}

	/**
	 * 根据PAGE SIZE ,PAGENUM获得所需的新闻
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticle> findArticleByPageNum(int start, int pageSize)
			throws ServiceException {
		String m = "findArticleByPageNum";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		List<ZyArticle> articles = articleDao.selectPaginationByPageNum(params);
		if (articles == null) {
			warn(m, "can't found any articles");
			return null;
		} else {
			info(m, "find " + articles.size() + " articles");
			return articles;
		}

	}

	/**
	 * 根据PAGE SIZE ,PAGENUM,parent Id获得所需的新闻分类
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticle> findArticlesByPageNumAndTypeId(int start,
			int pageSize, int typeId) throws ServiceException {
		String m = "findArticlesByPageNumAndTypeId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		params.put("typeId", typeId);
		List<ZyArticle> articles = articleDao.selectPaginationByPageNum(params);
		if (articles == null) {
			warn(m, "can't found any articles");
			return null;
		} else {
			info(m, "find " + articles.size() + " articles");
			return articles;
		}

	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countArticleList(ZyArticleParams params) throws ServiceException {
		String method = "countArticleList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = articleDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count articles by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count articles success by params=" + params.toString());

		return result;
	}

	/**
	 * 获得所有的新闻的总数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countAllArticles() throws ServiceException {
		String m = "countAllArticles";
		ZyArticleParams params = new ZyArticleParams();
		int count = countArticleList(params);
		if (count == 0) {
			warn(m, "can't found any articles,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 获得所有为TYPEID 的新闻的总数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countArticleListByTypeId(int typeId) throws ServiceException {
		String m = "countArticleListByParentId";
		ZyArticleParams params = new ZyArticleParams();
		params.createCriteria().andTypeIdEqualTo(typeId);
		int count = countArticleList(params);
		if (count == 0) {
			warn(m, "can't found any articles,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 获得所有的新闻的总数,新闻列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = articleDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any articles,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 获得所有TYPEID=typeId的新闻的总数,新闻列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPagerForWeb(Map<String, Object> map, boolean children)
			throws ServiceException {
		String m = "countSearchPager";
		int count = 0;
		if (!children) {
			count = articleDao.countPaginationByPageNum(map);
		} else {
			count = countArticlesWithChildren(map);
		}

		if (count == 0) {
			warn(m, "can't found any articles,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * ARTICLE 分页查询和搜索 获得所需的新闻
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticle> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyArticle> articles = articleDao.selectPaginationByPageNum(params);
		if (articles == null) {
			warn(m, "can't found any articles");
			return null;
		} else {
			info(m, "find " + articles.size() + " articles");
			return articles;
		}
	}

	/**
	 * 根据数量和文章类型查找,支持包含分页 或者子分类
	 * 
	 * @param typeId
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticle> findArticlesByCountAndArticleType(int typeId,
			int size, int pageNum, boolean pagnation, boolean containChilds) {
		String m = "findArticlesByCountAndArticleType";
		Map<String, Object> params = new HashMap<String, Object>();
		if (!pagnation) {
			params.put("start", 0);
			params.put("size", size);
		
		} else {
			int start = 0;
			if (pageNum <= 1) {
				start = 0;
			} else {
				start = (pageNum - 1) * size;
			}
			params.put("start", start);
			params.put("size", size);
		}
		params.put("typeId", typeId);
		params.put("status", "0");
		info(m, "params,start=" + params.get("start") + ",size=" + size
				+ ",typeiD=" + typeId);
		if (containChilds) {
			return getArticlesWithChildren(params);
		} else {
			return articleDao.selectPaginationByPageNum(params);
		}
		
	}

	/**
	 * 查询未审核的文章
	 * @param typeIds
	 * @param size
	 * @param pageNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticle> findArticlesWhichUncheck(String typeIds, int size,
			int pageNum) {
		String m = "findArticlesByCountAndArticleType";
		Map<String, Object> params = new HashMap<String, Object>();
		int start = 0;
		if (pageNum <= 1) {
			start = 0;
		} else {
			start = (pageNum - 1) * size;
		}
		params.put("start", start);
		params.put("size", size);
		params.put("typeId", typeIds);
		params.put("status", "1");
		info(m, "params,start=" + params.get("start") + ",size=" + size
				+ ",typeiD=" + typeIds);
		return articleDao.selectPaginationByTypeId(params);
	}

	/**
	 * 调用递归获得SQL
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticle> getArticlesWithChildren(Map<String, Object> params) {
		String m = "getArticlesWithChildren";
		// 初始化
		try{
		ids = new ArrayList<Integer>();
		List<Integer> idList = getAllChildrenTypeIds((Integer) params
				.get("typeId"));
		StringBuffer sb1 = new StringBuffer();
		sb1.append(params.get("typeId").toString());
		for (int id : idList) {
			sb1.append("," + id);
		}
		params.put("typeId", sb1.toString());
		info(m, "id list=" + idList);
	}catch(Exception e){
		e.printStackTrace();
	}

		return articleDao.selectPaginationByTypeId(params);
	}

	/**
	 * 调用递归获得SQL,然后查询总数
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int countArticlesWithChildren(Map<String, Object> params) {
		String m = "getArticlesWithChildren";
		// 初始化
		ids = new ArrayList<Integer>();
		List<Integer> idList = getAllChildrenTypeIds(Integer.parseInt(params
				.get("typeId").toString()));
		StringBuffer sb1 = new StringBuffer();
		sb1.append(params.get("typeId").toString());
		for (int id : idList) {
			sb1.append("," + id);
		}
		params.put("typeId", sb1.toString());
		params.put("status", "0");
		info(m, "id list=" + sb1.toString());
		return articleDao.countPaginationByTypeId(params);
	}

	/**
	 * 查询未审核的文章
	 * 
	 * @param params
	 * @return
	 */
	public int countArticlesWhichUncheck(Map<String, Object> params) {
		String m = "countArticlesWhichUncheck";
		params.put("status", "1");
		return articleDao.countPaginationByTypeId(params);
	}

	/**
	 * 获得所给TYPEID的所有子分类ID
	 * 
	 * @param typeId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Integer> getAllChildrenTypeIds(int typeId) {
		String method = "getAllChildrenTypeIds";
		List<ZyArticleType> childTypes = new ArrayList<ZyArticleType>();
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		params.createCriteria().andParentIdEqualTo(typeId);
		
			childTypes = articleTypeDao.selectByParams(params);
		
		if (childTypes.size() > 0) {
			for (ZyArticleType type : childTypes) {
				getAllChildrenTypeIds(type.getTypeId());
			}
		} else {
			ids.add(typeId);
		}
		return ids;
	}



	public int countSearchPagerWithRoleId(Map<String, Object> params) throws ServiceException {
		String m = "countSearchPagerWithRoleId";
		int count = articleDao.countSearchPagerWithRoleId(params);
		if (count == 0) {
			warn(m, "can't found any articles,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}
	@SuppressWarnings("unchecked")
	public List<ZyArticle> searchForPagerWithRoleId(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPagerWithRoleId";
		List<ZyArticle> articles = articleDao.searchForPagerWithRoleId(params);
		if (articles == null) {
			warn(m, "can't found any articles");
			return null;
		} else {
			info(m, "find " + articles.size() + " articles");
			return articles;
		}
	}	


}



