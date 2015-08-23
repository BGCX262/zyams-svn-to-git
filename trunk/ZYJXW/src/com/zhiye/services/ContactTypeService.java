package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyContactType;
import com.zhiye.common.bean.ZyContactTypeParams;
import com.zhiye.dao.ZyContactTypeDAO;

/**
 * @FileName:ContactTypeService.java
 * @ClassPath:com.zhiye.services
 * @Author:Arthur
 * @Create Time:2012-4-24下午09:42:23
 * @Email:arthurkingtoo@foxmail.com
 * @Company:www.maszy.cn
 */
public class ContactTypeService extends CommonService{
	
	private ZyContactTypeDAO contactTypeDAO;

	public ZyContactTypeDAO getContactTypeDAO() {
		return contactTypeDAO;
	}

	public void setContactTypeDAO(ZyContactTypeDAO contactTypeDAO) {
		this.contactTypeDAO = contactTypeDAO;
	}

	/**
	 * 添加联系人类型
	 * 
	 */
	public void addContactType(ZyContactType contactType) throws ServiceException {
		String method = "addContactType";
		if (contactType != null) {
			try {
				contactTypeDAO.insert(contactType);
			} catch (Exception e) {
				error(method, "add contactType dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add product successed! with product id=" + contactType.getTypeId());
	}
	
	@SuppressWarnings("unchecked")
	public List findContactTypeWithParams(ZyContactTypeParams params){
		return (List<ZyContactType>) contactTypeDAO.selectByParams(params);
	}
	
	/**
	 * 编辑,联系人类型管理
	 * @throws ServiceException 
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@return
	 * @Return:int
	 * @Throws
	 */
	public int updateContactType(ZyContactType contactType) throws ServiceException{
		String method = "updateContactType";
		int result=0;
		if (null != contactType) {
			try {
				result = contactTypeDAO.updateByPrimaryKey(contactType);
			} catch (Exception e) {
				error(method, "update contactType DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update contactType success with contactType id=" + contactType.getTypeId());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ZyContactType> findAllContactTypes(){
		String m="findAllContactTypes";
		ZyContactTypeParams param=new ZyContactTypeParams();
		
		return (List<ZyContactType>) contactTypeDAO.selectByParams(param);
		
	}
	
	/**
	 * 根据主键查询一个联系人类型
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@param id
	 * @Parameter:@return
	 * @Parameter:@throws ServiceException
	 * @Return:ZyProduct
	 * @Throws
	 */
	public ZyContactType findcontactTypeById(int rowid) throws ServiceException {
		String method = "findProductById";
		ZyContactType resultContactType = null;
		if (rowid > 0) {
			try {
				resultContactType = contactTypeDAO.selectByPrimaryKey(rowid);
			} catch (Exception e) {
				error(method, "find contactType by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find contactType id success by id =" + rowid);
		return resultContactType;
	}
	
	/**
	 * 根据主键ID删除联系人类型
	 * 
	 * @param partmentId
	 * @return
	 */
	public int deleteContactType(int rowid) throws ServiceException {
		String method = "deleteContactType";
		int result = 0;
		if (rowid > 0) {
			try {
				result = contactTypeDAO.deleteByPrimaryKey(rowid);
			} catch (Exception e) {
				error(method, "delete ContactType by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed ContactType by id=" + rowid);
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
	public List<ZyContactType> finDictionaryid(ZyContactTypeParams params) throws ServiceException{
		String method="finDictionaryid";
		List<ZyContactType> results = null;
			try{
				results = contactTypeDAO.selectByParams(params);
			}catch(Exception e){
				error(method, "find contactType by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
			}
			info(method, "find contactType by id");
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * product 分页查询和搜索 获得所需的数据
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyContactType> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyContactType> contactTypes = contactTypeDAO.selectPaginationByPageNum(params);
		if (contactTypes == null) {
			warn(m, "can't found any contactType");
			return null;
		} else {
			info(m, "find " + contactTypes.size() + " contactType");
			return contactTypes;
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
		int count = contactTypeDAO.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any contactTypes ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}
	
}
