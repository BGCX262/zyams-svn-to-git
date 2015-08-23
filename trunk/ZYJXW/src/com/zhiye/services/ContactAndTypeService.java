package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyContactAndType;
import com.zhiye.common.bean.ZyContactAndTypeParams;
import com.zhiye.dao.ZyContactAndTypeDAO;

/**
 * @FileName:ContactService.java
 * @ClassPath:com.zhiye.services
 * @Author:Arthur
 * @Create Time:2012-4-24下午09:42:23
 * @Email:arthurkingtoo@foxmail.com
 * @Company:www.maszy.cn
 */
public class ContactAndTypeService extends CommonService{
	
	private ZyContactAndTypeDAO contactAndTypeDAO;

	public ZyContactAndTypeDAO getContactAndTypeDAO() {
		return contactAndTypeDAO;
	}

	public void setContactAndTypeDAO(ZyContactAndTypeDAO contactAndTypeDAO) {
		this.contactAndTypeDAO = contactAndTypeDAO;
	}
	/**
	 * 添加联系人
	 * 
	 */
	public void addContactAndType(ZyContactAndType contactAndType) throws ServiceException {
		String method = "addContactAndType";
		if (contactAndType != null) {
			try {
				 contactAndTypeDAO.insert(contactAndType);
			} catch (Exception e) {
				error(method, "add contactAndType dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List findCorpsWithParams(ZyContactAndTypeParams params){
		return (List<ZyContactAndType>) contactAndTypeDAO.selectByParams(params);
	}
	
	
	/**
	 * 根据主键ID删除联系人
	 * 
	 * @param partmentId
	 * @return
	 */
	public int deleteContactAndTypeByContactId(int cid) throws ServiceException {
		String method = "deleteContactAndTypeByContactId";
		int result = 0;
		if (cid > 0) {
			try {
				ZyContactAndTypeParams param=new ZyContactAndTypeParams();
				param.createCriteria().andContactIdEqualTo(cid);
				result = contactAndTypeDAO.deleteByParams(param);
			} catch (Exception e) {
				error(method, "delete ContactAndType by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed ContactAndType by id=" + cid);
		return result;
	}

	

}
