package com.zhiye.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyCorporation;
import com.zhiye.common.bean.ZyCorporationParams;
import com.zhiye.common.bean.ZyIndex;
import com.zhiye.dao.ZyCorporationDAO;

/**
 * @FileName:CorporationService.java
 * @ClassPath:com.zhiye.services
 * @Author:Arthur
 * @Create Time:2012-4-24下午09:42:23
 * @Email:arthurkingtoo@foxmail.com
 * @Company:www.maszy.cn
 */
public class CorporationService extends CommonService{
	
	private ZyCorporationDAO corporationDAO;

	public ZyCorporationDAO getCorporationDAO() {
		return corporationDAO;
	}

	public void setCorporationDAO(ZyCorporationDAO corporationDAO) {
		this.corporationDAO = corporationDAO;
	}
	/**
	 * 添加企业
	 * 
	 */
	public void addCorporation(ZyCorporation corporation) throws ServiceException {
		String method = "addCorporation";
		if (corporation != null) {
			try {
				corporationDAO.insert(corporation);
			} catch (Exception e) {
				error(method, "add corporation dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add product successed! with product id=" + corporation.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List findCorpsWithParams(ZyCorporationParams params){
		return (List<ZyCorporation>) corporationDAO.selectByExample(params);
	}
	
	/**
	 * 编辑,企业管理
	 * @throws ServiceException 
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@return
	 * @Return:int
	 * @Throws
	 */
	public int updateCorporation(ZyCorporation corporation) throws ServiceException{
		String method = "updateCorporation";
		int result=0;
		if (null != corporation) {
			try {
				result = corporationDAO.updateByPrimaryKey(corporation);
			} catch (Exception e) {
				error(method, "update corporation DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update corporation success with corporation id=" + corporation.getRowid());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ZyCorporation> findAllCorporations(){
		String m="findAllCorporations";
		ZyCorporationParams param=new ZyCorporationParams();
		
		return (List<ZyCorporation>) corporationDAO.selectByExample(param);
		
	}
	
	/**
	 * 根据主键查询一个企业
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@param id
	 * @Parameter:@return
	 * @Parameter:@throws ServiceException
	 * @Return:ZyProduct
	 * @Throws
	 */
	public ZyCorporation findcorporationById(int rowid) throws ServiceException {
		String method = "findProductById";
		ZyCorporation resultCorporation = null;
		if (rowid > 0) {
			try {
				resultCorporation = corporationDAO.selectByPrimaryKey(rowid);
			} catch (Exception e) {
				error(method, "find corporation by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find corporation id success by id =" + rowid);
		return resultCorporation;
	}
	
	/**
	 * 根据主键ID删除企业
	 * 
	 * @param partmentId
	 * @return
	 */
	public int deleteCorporation(int rowid) throws ServiceException {
		String method = "deleteCorporation";
		int result = 0;
		if (rowid > 0) {
			try {
				result = corporationDAO.deleteByPrimaryKey(rowid);
			} catch (Exception e) {
				error(method, "delete Corporation by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed Corporation by id=" + rowid);
		return result;
	}
	
	
	
	/**
	 * 查出所有信息
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@param params
	 * @Parameter:@return
	 * @Parameter:@throws ServiceException
	 * @Return:List<ZyDictionary>
	 * @Throws
	 */
	public List<ZyCorporation> finDictionaryid() throws ServiceException{
		String method="finDictionaryid";
		List<ZyCorporation> results = null;
			try{
				results = corporationDAO.selectByExample();
			}catch(Exception e){
				error(method, "find corporation by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
			}
			info(method, "find corporation by id");
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * product 分页查询和搜索 获得所需的数据
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyCorporation> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyCorporation> corporations = corporationDAO.selectPaginationByPageNum(params);
		if (corporations == null) {
			warn(m, "can't found any corporation");
			return null;
		} else {
			info(m, "find " + corporations.size() + " corporation");
			return corporations;
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
		int count = corporationDAO.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any corporations ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}
	/**
	 * 企业 分页查询和搜索 获得所需的数据 带申报
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<Map> searchForPagerWithIndex(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<Map> corporations = corporationDAO.selectPaginationWithIndex(params);
//		List<ZyCorporation> resultList=new ArrayList<ZyCorporation>(corporations.size());
//		for(Map map:corporations){
//			ZyCorporation c=new ZyCorporation();
//			c.setRowid(Integer.parseInt(map.get("RowID").toString()));
//			c.setName(map.get("name").toString());
//			Object indexIdObj=map.get("id");
//			if(indexIdObj!=null){
//				c.setIndexId(Integer.parseInt(indexIdObj.toString().trim()));
//				c.setStatus(map.get("status").toString());
//			}
//			resultList.add(c);
//		}
		
		if (corporations == null) {
			warn(m, "can't found any corporation");
			return null;
		} else {
			info(m, "find " + corporations.size() + " corporation");
			return corporations;
		}

	}
	/**
	 * 根据地区查找符合条件申报
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> searchListByArea(Map<String, Object> params)
			throws ServiceException {
		String m = "searchListByArea";
		List<ZyIndex> indexs = corporationDAO.selectIndexsWithArea(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " corporation");
			return indexs;
		}

	}
	
	/**
	 * 根据行业查找符合条件申报
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> searchListByTrade(Map<String, Object> params)
			throws ServiceException {
		String m = "searchListByTrade";
		List<ZyIndex> indexs = corporationDAO.selectIndexsWithTrade(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}
	}
	
	/**
	 * 根据企业ID，或者是否为IS50查找符合条件申报
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> searchListByCorp(Map<String, Object> params)
			throws ServiceException {
		String m = "searchListByCorp";
		List<ZyIndex> indexs = corporationDAO.selectIndexsWithCorp(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}
	}
	
	/**
	 * 查找所有企业的申报
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> findAllIndexsByCorp(Map<String, Object> params)
			throws ServiceException {
		String m = "findAllIndexsByCorp";
		List<ZyIndex> indexs = corporationDAO.selectAllIndexsByCorp(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}
	}
}
