package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyPartmentParams;
import com.zhiye.dao.ZyPartmentDAO;

public class PartmentService extends CommonService {
	private ZyPartmentDAO partmentDao;
	
	public ZyPartmentDAO getPartmentDao(){
		return partmentDao;
	}
	public void setPartmentDao(ZyPartmentDAO partmentDao){
		this.partmentDao=partmentDao;
	}
	/**
	 * 添加部门
	 * 
	 */
	public void addPartment(ZyPartment partment) throws ServiceException {
		String method = "addPartment";
		if (partment != null) {
			try {
				partmentDao.insert(partment);
			} catch (Exception e) {
				error(method, "add partment dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add partment successed! with partment id=" + partment.getPartmentId());
	}

	/**
	 * 更新部门
	 * 
	 * @param partment
	 * @return
	 */
	public int updatePartment(ZyPartment partment) throws ServiceException {
		String method = "updatePartment";
		int result = 0;
		if (null != partment) {
			try {
				result = partmentDao.updateByPrimaryKey(partment);
			} catch (Exception e) {
				error(method, "update partment DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update partment success with partmentid=" + partment.getPartmentId());
		return result;
	}

	/**
	 * 根据主键ID 查询 partment
	 * 
	 * @param partmentId
	 * @return
	 */
	public ZyPartment findPartmentById(int partmentId) throws ServiceException {
		String method = "findPartmentById";
		ZyPartment resultPartment = null;
		if (partmentId > 0) {
			try {
				resultPartment = partmentDao.selectByPrimaryKey(partmentId);
			} catch (Exception e) {
				error(method, "find partment by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			return new ZyPartment();
		}
		info(method, "find partment success by id =" + partmentId);
		return resultPartment;
	}

	/**
	 * 根据主键ID删除部门
	 * 
	 * @param partmentId
	 * @return
	 */
	public int removePartmentById(int partmentId) throws ServiceException {
		String method = "removePartmentById";
		int result = 0;
		if (partmentId > 0) {
			try {
				result = partmentDao.deleteByPrimaryKey(partmentId);
			} catch (Exception e) {
				error(method, "delete partment by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed partment by id=" + partmentId);
		return result;
	}

	/**
	 * 批量查询 获得partment
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyPartment> findPartmentList(ZyPartmentParams params)
			throws ServiceException {
		String method = "findPartmentList";
		List<ZyPartment> partments = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			partments = partmentDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find partment by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query partments success by params=" + params.toString());

		return partments;
	}
	
	/**
	 * 获得所有的部门列表
	 * @return
	 */
	public List<ZyPartment> findAllPartments() throws ServiceException{
		String method="findAllPartments";
		ZyPartmentParams params=new ZyPartmentParams();
		try {
			return findPartmentList(params);
		} catch (ServiceException e) {
			error(method, "find partments by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countPartmentList(ZyPartmentParams params) throws ServiceException {
		String method = "countPartmentList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = partmentDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count partments by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count partments success by params=" + params.toString());

		return result;
	}
	
	
	/**
	 * 获得所有的部门的总数,部门列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = partmentDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any partments ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * PARTMENT分页查询和搜索 获得所需的部门
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyPartment> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyPartment> partments = partmentDao.selectPaginationByPageNum(params);
		if (partments == null) {
			warn(m, "can't found any partments");
			return null;
		} else {
			info(m, "find " + partments.size() + " partments");
			return partments;
		}

	}
	
	/**
	 * 根据角色名查询，部门
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyPartment findPartmentByName(String name)
			throws ServiceException {
		String method = "findPartmentByName";
		List<ZyPartment> partments = null;
		if (null == name) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		ZyPartmentParams params=new ZyPartmentParams();
		params.createCriteria().andPartmentNameEqualTo(name);
		try {
			partments = partmentDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find partments by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query partments success by name=" + params.toString());
		if(partments!=null&&partments.size()>0){
			return partments.get(0);
		}else{
			return null;
		}
			
	}
}
