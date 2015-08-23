package com.zhiye.dao;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyPartmentParams;
import com.zhiye.common.bean.ZyRole;

public class ZyPartmentDAOImpl  extends CommonDAO  implements ZyPartmentDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public ZyPartmentDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public void insert(ZyPartment record) {
        getSqlMapClientTemplate().insert("zy_partment.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByPrimaryKey(ZyPartment record) {
        int rows = getSqlMapClientTemplate().update("zy_partment.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByPrimaryKeySelective(ZyPartment record) {
        int rows = getSqlMapClientTemplate().update("zy_partment.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public List selectByParams(ZyPartmentParams example) {
        List list = getSqlMapClientTemplate().queryForList("zy_partment.selectByParams", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public ZyPartment selectByPrimaryKey(Integer partmentId) {
        ZyPartment key = new ZyPartment();
        key.setPartmentId(partmentId);
        ZyPartment record = (ZyPartment) getSqlMapClientTemplate().queryForObject("zy_partment.selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int deleteByParams(ZyPartmentParams example) {
        int rows = getSqlMapClientTemplate().delete("zy_partment.deleteByParams", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int deleteByPrimaryKey(Integer partmentId) {
        ZyPartment key = new ZyPartment();
        key.setPartmentId(partmentId);
        int rows = getSqlMapClientTemplate().delete("zy_partment.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int countByParams(ZyPartmentParams example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("zy_partment.countByParams", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByParamsSelective(ZyPartment record, ZyPartmentParams example) {
        UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
        int rows = getSqlMapClientTemplate().update("zy_partment.updateByParamsSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByParams(ZyPartment record, ZyPartmentParams example) {
        UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
        int rows = getSqlMapClientTemplate().update("zy_partment.updateByParams", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    private static class UpdateByParamsParms extends ZyPartmentParams {
        private Object record;

        public UpdateByParamsParms(Object record, ZyPartmentParams example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    /**
     * 分页查询
     */
	public int countPaginationByPageNum(Map<String, Object> map) {
		String m = "countPaginationByPageNum";
		int result = 0;
		if (map != null) {
			result = (Integer) getSqlMapClientTemplate().queryForObject(
					"zy_partment.countPaginationByPageNum", map);
		} else {
			return 0;
		}
		return result;
	}

	public List selectPaginationByPageNum(Map<String, Object> map) {
		String m = "selectPaginationByPageNum";
		List<ZyPartment> partments = null;
		if (map != null) {
			partments = getSqlMapClientTemplate().queryForList(
					"zy_partment.selectPaginationByPageNum", map);
		} else {
			return null;
		}
		return partments;
	}
}