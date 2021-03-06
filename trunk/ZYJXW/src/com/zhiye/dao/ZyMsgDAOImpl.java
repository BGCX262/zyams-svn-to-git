package com.zhiye.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zhiye.common.bean.ZyMsg;
import com.zhiye.common.bean.ZyMsgParams;

public class ZyMsgDAOImpl extends SqlMapClientDaoSupport implements ZyMsgDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public ZyMsgDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public void insert(ZyMsg record) {
        getSqlMapClientTemplate().insert("zy_msg.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int updateByPrimaryKeyWithoutBLOBs(ZyMsg record) {
        int rows = getSqlMapClientTemplate().update("zy_msg.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int updateByPrimaryKeyWithBLOBs(ZyMsg record) {
        int rows = getSqlMapClientTemplate().update("zy_msg.updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int updateByPrimaryKeySelective(ZyMsg record) {
        int rows = getSqlMapClientTemplate().update("zy_msg.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public List selectByParamsWithoutBLOBs(ZyMsgParams example) {
        List list = getSqlMapClientTemplate().queryForList("zy_msg.selectByParams", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public List selectByParamsWithBLOBs(ZyMsgParams example) {
        List list = getSqlMapClientTemplate().queryForList("zy_msg.selectByParamsWithBLOBs", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public ZyMsg selectByPrimaryKey(Long msgId) {
        ZyMsg key = new ZyMsg();
        key.setMsgId(msgId);
        ZyMsg record = (ZyMsg) getSqlMapClientTemplate().queryForObject("zy_msg.selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int deleteByParams(ZyMsgParams example) {
        int rows = getSqlMapClientTemplate().delete("zy_msg.deleteByParams", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int deleteByPrimaryKey(Long msgId) {
        ZyMsg key = new ZyMsg();
        key.setMsgId(msgId);
        int rows = getSqlMapClientTemplate().delete("zy_msg.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int countByParams(ZyMsgParams example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("zy_msg.countByParams", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int updateByParamsSelective(ZyMsg record, ZyMsgParams example) {
        UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
        int rows = getSqlMapClientTemplate().update("zy_msg.updateByParamsSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int updateByParamsWithBLOBs(ZyMsg record, ZyMsgParams example) {
        UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
        int rows = getSqlMapClientTemplate().update("zy_msg.updateByParamsWithBLOBs", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public int updateByParamsWithoutBLOBs(ZyMsg record, ZyMsgParams example) {
        UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
        int rows = getSqlMapClientTemplate().update("zy_msg.updateByParams", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    private static class UpdateByParamsParms extends ZyMsgParams {
        private Object record;

        public UpdateByParamsParms(Object record, ZyMsgParams example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    /**
	 * 根据MAP进行分页
	 */
	@SuppressWarnings("unchecked")
	public List selectPaginationByPageNum(Map<String, Object> map) {
		String m = "selectPaginationByPageNum";
		List<ZyMsg> msgs = null;
		if (map != null) {
			msgs = getSqlMapClientTemplate().queryForList(
					"zy_msg.selectPaginationByPageNum", map);
		} else {
			return null;
		}
		return msgs;
	}

	public int countPaginationByPageNum(Map<String, Object> map) {
		String m = "countPaginationByPageNum";
		int result = 0;
		if (map != null) {
			result = (Integer) getSqlMapClientTemplate().queryForObject(
					"zy_msg.countPaginationByPageNum", map);
		} else {
			return 0;
		}
		return result;
	}
}