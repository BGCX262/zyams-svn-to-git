package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyDictionary;
import com.zhiye.dao.ZyDictionaryDAO;

public class DictionaryService extends CommonService{
	
	private ZyDictionaryDAO dictionaryDAO;

	public ZyDictionaryDAO getDictionaryDAO() {
		return dictionaryDAO;
	}

	public void setDictionaryDAO(ZyDictionaryDAO dictionaryDAO) {
		this.dictionaryDAO = dictionaryDAO;
	}
	
	
	public List<ZyDictionary> finDictionaryDictid(Map<String, Object> params) throws ServiceException{
		String method="finDictionaryDictid";
		List<ZyDictionary> results = null;
		if(null != params){
			try{
				results = dictionaryDAO.selectByPrimaryKey(params);
			}catch(Exception e){
				error(method, "find dictionary by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
			}
		}else {
				throw new ServiceException(ServiceException.ID_NULL_ERROR);
			}
			info(method, "find dictionary by dictid=" + params);
		return results;
	}
	

	/**
	 * 根据名称查找行业，地区
	 * 
	 * @param Name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyDictionary findDictionaryByName(String name,String dictid) throws ServiceException {
		String method = "findDictionaryByName";
		ZyDictionary resultDictionary = null;
		if(null != name || null != dictid){
			try{
				resultDictionary = dictionaryDAO.selectByPrimaryKey(name,dictid);
			}catch(Exception e){
				error(method, "delete dictionary by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
			}
		}else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find dictionary by dictid=" + dictid);
		info(method, "find dictionary by name=" + name);
		return resultDictionary;
	}
	
	
	/**
	 * 添加行业，地区
	 * 
	 */
	public void addDictionary(ZyDictionary dictionary) throws ServiceException {
		String method = "addDictionary";
		if (dictionary != null) {
			try {
				dictionaryDAO.insert(dictionary);
			} catch (Exception e) {
				error(method, "add dictionary dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add dictionary successed! with dictionary id=" + dictionary.getCode());
	}
	
	
	/**
	 * 根据主键ID删除行业,地区
	 * 
	 * @param partmentId
	 * @return
	 */
	public int removeDictionaryById(int code) throws ServiceException {
		String method = "removeDictionaryById";
		int result = 0;
		if (code > 0) {
			try {
				result = dictionaryDAO.deleteByPrimaryKey(code);
			} catch (Exception e) {
				error(method, "delete dictionary by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed dictionary by id=" + code);
		return result;
	}
	
	
	
	
	/**
	 * 根据主键ID 查询 dictionary
	 * 
	 * @param roleId
	 * @return
	 */
	public ZyDictionary findDictionaryById(int code) throws ServiceException {
		String method = "findDictionaryById";
		ZyDictionary resultDictionary = null;
		if (code > 0) {
			try {
				resultDictionary = dictionaryDAO.selectByPrimaryKey(code);
			} catch (Exception e) {
				error(method, "find Dictionary by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find Dictionary success by id =" + code);
		return resultDictionary;
	}
	
	
	/**
	 * 更新行业,地区
	 * 
	 * @param partment
	 * @return
	 */
	public int updateDictionary(ZyDictionary pictionary) throws ServiceException {
		String method = "updateDictionary";
		int result = 0;
		if (null != pictionary) {
			try {
				result = dictionaryDAO.updateByPrimaryKey(pictionary);
			} catch (Exception e) {
				error(method, "update pictionary DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update pictionary success with pictionaryid=" + pictionary.getCode());
		return result;
	}
	
	
	
	
	
	
	/**
	 * product 分页查询和搜索 获得所需的数据
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyDictionary> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyDictionary> dictionarys = dictionaryDAO.selectPaginationByPageNum(params);
		if (dictionarys == null) {
			warn(m, "can't found any dictionary");
			return null;
		} else {
			info(m, "find " + dictionarys.size() + " dictionary");
			return dictionarys;
		}

	}
	
	/**
	 * 获得数据的总数,列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = dictionaryDAO.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any dictionarys ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}
}
