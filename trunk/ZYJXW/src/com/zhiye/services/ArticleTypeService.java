package com.zhiye.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyArticleTypeParams;
import com.zhiye.common.util.Constant;
import com.zhiye.dao.ZyArticleTypeDAO;

public class ArticleTypeService extends CommonService {
	private ZyArticleTypeDAO articleTypeDao;

	public ZyArticleTypeDAO getArticleTypeDao() {
		return articleTypeDao;
	}

	public void setArticleTypeDao(ZyArticleTypeDAO articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}

	/**
	 * 添加文章分类
	 * 
	 */
	public void addArticleType(ZyArticleType articleType)
			throws ServiceException {
		String method = "addArticleType";
		if (articleType != null) {
			try {
				articleTypeDao.insert(articleType);
			} catch (Exception e) {
				error(method, "add articleType dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add articleType successed! with articleType id="
				+ articleType.getTypeId());
	}

	/**
	 * 更新文章分类
	 * 
	 * @param articleType
	 * @return
	 */
	public int updateArticleType(ZyArticleType articleType)
			throws ServiceException {
		String method = "updateArticleType";
		int result = 0;
		if (null != articleType) {
			try {
				result = articleTypeDao
						.updateByPrimaryKeySelective(articleType);
			} catch (Exception e) {
				error(method, "update articleType DAO exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update articleType success with articleTypeid="
				+ articleType.getTypeId());
		return result;
	}

	/**
	 * 根据主键ID 查询 ARTICLE TYPE
	 * 
	 * @param articleTypeId
	 * @return
	 */
	public ZyArticleType findArticleTypeById(int articleTypeId)
			throws ServiceException {
		String method = "findArticleTypeById";
		ZyArticleType resultArticleType = null;
		if (articleTypeId >= 0) {
			try {
				resultArticleType = articleTypeDao
						.selectByPrimaryKey(articleTypeId);
			} catch (Exception e) {
				error(method, "find articleType by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find articleType success by id =" + articleTypeId);
		return resultArticleType;
	}

	/**
	 * 根据主键ID删除文章分类
	 * 
	 * @param articleTypeId
	 * @return
	 */
	public int removeArticleTypeById(int articleTypeId) throws ServiceException {
		String method = "removeArticleTypeById";
		int result = 0;
		if (articleTypeId > 0) {
			try {
				result = articleTypeDao.deleteByPrimaryKey(articleTypeId);
			} catch (Exception e) {
				error(method, "delete articleType by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed articleType by id=" + articleTypeId);
		return result;
	}

	/**
	 * 批量查询 获得ARTICLE TYPE
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticleType> findArticleTypeList(ZyArticleTypeParams params)
			throws ServiceException {
		String method = "findArticleTypeList";
		List<ZyArticleType> articleTypes = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			articleTypes = articleTypeDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find articleType by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query articleTypes success by params="
				+ params.toString());

		return articleTypes;
	}

	/**
	 * 根据父类的ID 获得ARTICLE TYPE
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticleType> findArticleTypeListByParentId(int parentId)
			throws ServiceException {
		String method = "findArticleTypeList";
		List<ZyArticleType> articleTypes = null;
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		params.createCriteria().andParentIdEqualTo(parentId);
		try {
			articleTypes = articleTypeDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find articleType by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query articleTypes success by params="
				+ params.toString());

		return articleTypes;
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countArticleTypeList(ZyArticleTypeParams params)
			throws ServiceException {
		String method = "countArticleTypeList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = articleTypeDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count articleTypes by params=" + params.toString(),
					e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count articleTypes success by params="
				+ params.toString());

		return result;
	}

	/**
	 * 获得所有的新闻分类
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<ZyArticleType> findAllArticleTypes() throws ServiceException {
		String m = "findAllArticleTypes";
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		List<ZyArticleType> types = findArticleTypeList(params);
		if (types == null) {
			warn(m, "can't found any articleTypes");
			return null;
		} else {
			info(m, "find " + types.size() + " articleTypes");
			return types;
		}

	}

	/**
	 * ARTICLE TYPE分页查询和搜索 获得所需的新闻分类
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticleType> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyArticleType> types = articleTypeDao
				.selectPaginationByPageNum(params);
		if (types == null) {
			warn(m, "can't found any articleTypes");
			return null;
		} else {
			info(m, "find " + types.size() + " articleTypes");
			return types;
		}

	}

	/**
	 * 根据PAGE SIZE ,PAGENUM,parent Id获得所需的新闻分类
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyArticleType> findArticleTypesByPageNumAndParentId(int start,
			int pageSize, int parentId) throws ServiceException {
		String m = "findArticleTypesByPageNum";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		params.put("parent_id", parentId);
		List<ZyArticleType> types = articleTypeDao
				.selectPaginationByPageNum(params);
		if (types == null) {
			warn(m, "can't found any articleTypes");
			return null;
		} else {
			info(m, "find " + types.size() + " articleTypes");
			return types;
		}

	}

	/**
	 * 获得所有的新闻分类的总数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countAllArticleTypes() throws ServiceException {
		String m = "countAllArticleTypes";
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		int count = countArticleTypeList(params);
		if (count == 0) {
			warn(m, "can't found any articleTypes,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}
	
	/**
	 * 获得所有的新闻分类的总数,分类列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String,Object> map) throws ServiceException {
		String m = "countSearchPager";
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		Object typename=map.get("type_name");
		if(null!=typename&&typename.toString().trim().length()>0){
			params.createCriteria().andTypeNameLike(typename.toString());
		}
		int count = countArticleTypeList(params);
		if (count == 0) {
			warn(m, "can't found any articleTypes,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 获得所有为PARENTID 的新闻分类的总数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countArticleTypeListByParentId(int parentId)
			throws ServiceException {
		String m = "countArticleTypeListByParentId";
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		params.createCriteria().andParentIdEqualTo(parentId);
		int count = countArticleTypeList(params);
		if (count == 0) {
			warn(m, "can't found any articleTypes,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 根据新闻分类进行查询分类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyArticleType findArticleTypeByTypeName(String name) {
		String m = "findArticleTypeByTypeName";
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		params.createCriteria().andTypeNameEqualTo(name);
		List<ZyArticleType> types = articleTypeDao.selectByParams(params);
		if (null != types&&types.size()>0) {
			return types.get(0);
		}
		return null;
	}
	
	/**
	 * 根据新闻分类进行查询分类，模糊查询
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyArticleType findArticleTypeLikeName(String name) {
		String m = "findArticleTypeLikeName";
		ZyArticleTypeParams params = new ZyArticleTypeParams();
		params.createCriteria().andTypeNameLike(name);
		List<ZyArticleType> types = articleTypeDao.selectByParams(params);
		if (null != types) {
			return types.get(0);
		}
		return null;
	}
	
	
	/**
	 * 获得所有类型，并用MAP方式返回
	 * @return
	 */
	public Map<Integer,List<ZyArticleType>> getAllTypeMap(){
		String m="getAllTypeMap";
		
		try {
			List<ZyArticleType> allTypes=findAllArticleTypes();
			int key = 0;
			List<ZyArticleType> values = null;
			Map<Integer, List<ZyArticleType>> map = new TreeMap<Integer, List<ZyArticleType>>();
			for(int i=0;i<allTypes.size();i++){
			    key = allTypes.get(i).getParentId();
			    if(map.containsKey(key)){
			        values = map.get(key);
			    } else {
			        values = new ArrayList<ZyArticleType>();
			    }
			    values.add(allTypes.get(i));
			    map.put(key, values);
			}
			return map;

		} catch (ServiceException e) {
			error(m,"find all article types exception",e);
		}catch(Exception e){
			error(m,"unknown exception",e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得所有新闻类型，并用MAP方式返回
	 * @return
	 */
	public Map<Integer,List<ZyArticleType>> getAllNewsTypeMap(){
		String m="getAllNewsTypeMap";
		
		try {
			ZyArticleTypeParams params=new ZyArticleTypeParams();
			params.createCriteria().andTypeEqualTo(Constant.NEWS);
			List<ZyArticleType> allNewsTypes=findArticleTypeList(params);
			int key = 0;
			List<ZyArticleType> values = null;
			Map<Integer, List<ZyArticleType>> map = new TreeMap<Integer, List<ZyArticleType>>();
			for(int i=0;i<allNewsTypes.size();i++){
			    key = allNewsTypes.get(i).getParentId();
			    if(map.containsKey(key)){
			        values = map.get(key);
			    } else {
			        values = new ArrayList<ZyArticleType>();
			    }
			    values.add(allNewsTypes.get(i));
			    map.put(key, values);
			}
			return map;

		} catch (ServiceException e) {
			error(m,"find all new article types exception",e);
		}catch(Exception e){
			error(m,"unknown exception",e);
			e.printStackTrace();
		}
		return null;
	}
}
