package com.zhiye.services;

import java.util.List;

import com.zhiye.common.bean.ZyCompany;
import com.zhiye.common.bean.ZyCompanyParams;
import com.zhiye.dao.ZyCompanyDAO;

public class CompanyService extends CommonService {
	private ZyCompanyDAO companyDao;
	
	public ZyCompanyDAO getCompanyDao(){
		return companyDao;
	}
	public void setCompanyDao(ZyCompanyDAO companyDao){
		this.companyDao=companyDao;
	}
	/**
	 * 添加企业
	 * 
	 */
	public int  addCompany(ZyCompany company) throws ServiceException {
		String method = "addCompany";
		if (company != null) {
			try {
				info(method, "add company successed! with company id=" + company.getCompanyId());
				return companyDao.insert(company);
			} catch (Exception e) {
				error(method, "add company dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
	}

	/**
	 * 更新企业
	 * 
	 * @param company
	 * @return
	 */
	public int updateCompany(ZyCompany company) throws ServiceException {
		String method = "updateCompany";
		int result = 0;
		if (null != company) {
			try {
				result = companyDao.updateByPrimaryKey(company);
			} catch (Exception e) {
				error(method, "update company DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update company success with companyid=" + company.getCompanyId());
		return result;
	}

	/**
	 * 根据主键ID 查询 COMPANY
	 * 
	 * @param companyId
	 * @return
	 */
	public ZyCompany findCompanyById(int companyId) throws ServiceException {
		String method = "findCompanyById";
		ZyCompany resultCompany = null;
		if (companyId > 0) {
			try {
				resultCompany = companyDao.selectByPrimaryKey(companyId);
			} catch (Exception e) {
				error(method, "find company by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find company success by id =" + companyId);
		return resultCompany;
	}

	/**
	 * 根据主键ID删除企业
	 * 
	 * @param companyId
	 * @return
	 */
	public int removeCompanyById(int companyId) throws ServiceException {
		String method = "removeCompanyById";
		int result = 0;
		if (companyId > 0) {
			try {
				result = companyDao.deleteByPrimaryKey(companyId);
			} catch (Exception e) {
				error(method, "delete company by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed company by id=" + companyId);
		return result;
	}

	/**
	 * 批量查询 获得COMPANY
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyCompany> findCompanyList(ZyCompanyParams params)
			throws ServiceException {
		String method = "findCompanyList";
		List<ZyCompany> companys = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			companys = companyDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find company by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query companys success by params=" + params.toString());

		return companys;
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countCompanyList(ZyCompanyParams params) throws ServiceException {
		String method = "countCompanyList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = companyDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count companys by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count companys success by params=" + params.toString());

		return result;
	}
}
