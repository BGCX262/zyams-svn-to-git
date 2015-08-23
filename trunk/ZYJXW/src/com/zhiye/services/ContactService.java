package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyContact;
import com.zhiye.common.bean.ZyContactParams;
import com.zhiye.common.bean.ZyContactType;
import com.zhiye.dao.ZyContactDAO;

/**
 * @FileName:ContactService.java
 * @ClassPath:com.zhiye.services
 * @Author:Arthur
 * @Create Time:2012-4-24下午09:42:23
 * @Email:arthurkingtoo@foxmail.com
 * @Company:www.maszy.cn
 */
public class ContactService extends CommonService{
	
	private ZyContactDAO contactDAO;

	public ZyContactDAO getContactDAO() {
		return contactDAO;
	}

	public void setContactDAO(ZyContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	/**
	 * 添加联系人
	 * 
	 */
	public int addContact(ZyContact contact) throws ServiceException {
		String method = "addContact";
		if (contact != null) {
			try {
				return contactDAO.insert(contact);
			} catch (Exception e) {
				error(method, "add contact dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List findCorpsWithParams(ZyContactParams params){
		return (List<ZyContact>) contactDAO.selectByParams(params);
	}
	
	/**
	 * 编辑,联系人管理
	 * @throws ServiceException 
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@return
	 * @Return:int
	 * @Throws
	 */
	public int updateContact(ZyContact contact) throws ServiceException{
		String method = "updateContact";
		int result=0;
		if (null != contact) {
			try {
				result = contactDAO.updateByPrimaryKey(contact);
			} catch (Exception e) {
				error(method, "update contact DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update contact success with contact id=" + contact.getContactId());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ZyContact> findAllContacts(){
		String m="findAllContacts";
		ZyContactParams param=new ZyContactParams();
		
		return (List<ZyContact>) contactDAO.selectByParams(param);
		
	}
	
	/**
	 * 根据主键查询一个联系人
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@param id
	 * @Parameter:@return
	 * @Parameter:@throws ServiceException
	 * @Return:ZyProduct
	 * @Throws
	 */
	public ZyContact findcontactById(int rowid) throws ServiceException {
		String method = "findProductById";
		ZyContact resultContact = null;
		if (rowid > 0) {
			try {
				resultContact = contactDAO.selectByPrimaryKey(rowid);
			} catch (Exception e) {
				error(method, "find contact by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find contact id success by id =" + rowid);
		return resultContact;
	}
	
	/**
	 * 根据主键ID删除联系人
	 * 
	 * @param partmentId
	 * @return
	 */
	public int deleteContact(int rowid) throws ServiceException {
		String method = "deleteContact";
		int result = 0;
		if (rowid > 0) {
			try {
				result = contactDAO.deleteByPrimaryKey(rowid);
			} catch (Exception e) {
				error(method, "delete Contact by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed Contact by id=" + rowid);
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
	public List<ZyContact> finDictionaryid(ZyContactParams params) throws ServiceException{
		String method="finDictionaryid";
		List<ZyContact> results = null;
			try{
				results = contactDAO.selectByParams(params);
			}catch(Exception e){
				error(method, "find contact by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
			}
			info(method, "find contact by id");
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * contact 分页查询和搜索 获得所需的数据
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyContact> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyContact> contacts = contactDAO.selectPaginationByPageNum(params);
		if (contacts == null) {
			warn(m, "can't found any contact");
			return null;
		} else {
			info(m, "find " + contacts.size() + " contact");
			return contacts;
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
		int count = contactDAO.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any contacts ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}
	@SuppressWarnings("unchecked")
	public List<ZyContactType> selectTypesByContactId(Map<String, Object> map){
		String m = "selectTypesByContactId";
		List<ZyContactType> contacts = contactDAO.selectTypesByContactId(map);
		if (contacts == null) {
			warn(m, "can't found any contact types");
			return null;
		} else {
			info(m, "find " + contacts.size() + " contact types");
			return contacts;
		}
	}

	@SuppressWarnings("unchecked")
	public List selectContactByTypeId(Map<String, Object> map){
		String m = "selectContactByTypeId";
		List<ZyContactType> contacts = contactDAO.selectContactByTypeId(map);
		if (contacts == null) {
			warn(m, "can't found any contact ");
			return null;
		} else {
			info(m, "find " + contacts.size() + " contact ");
			return contacts;
		}
	}
}
