package com.zhiye.dao;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.bean.ZyUserParams;

public class ZyUserDAOImpl  extends CommonDAO  implements ZyUserDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public ZyUserDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public void insert(ZyUser record) {
        getSqlMapClientTemplate().insert("zy_user.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByPrimaryKey(ZyUser record) {
        int rows = getSqlMapClientTemplate().update("zy_user.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByPrimaryKeySelective(ZyUser record) {
        int rows = getSqlMapClientTemplate().update("zy_user.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public List selectByParams(ZyUserParams example) {
        List list = getSqlMapClientTemplate().queryForList("zy_user.selectByParams", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public ZyUser selectByPrimaryKey(Integer userid) {
        ZyUser record = (ZyUser) getSqlMapClientTemplate().queryForObject("zy_user.selectByPrimaryKey", userid);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int deleteByParams(ZyUserParams example) {
        int rows = getSqlMapClientTemplate().delete("zy_user.deleteByParams", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int deleteByPrimaryKey(Integer userid) {
        ZyUser key = new ZyUser();
        key.setUserId(userid);
        int rows = getSqlMapClientTemplate().delete("zy_user.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int countByParams(ZyUserParams example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("zy_user.countByParams", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByParamsSelective(ZyUser record, ZyUserParams example) {
        UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
        int rows = getSqlMapClientTemplate().update("zy_user.updateByParamsSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public int updateByParams(ZyUser record, ZyUserParams example) {
        UpdateByParamsParms parms = new UpdateByParamsParms(record, example);
        int rows = getSqlMapClientTemplate().update("zy_user.updateByParams", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table zy_user
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    private static class UpdateByParamsParms extends ZyUserParams {
        private Object record;

        public UpdateByParamsParms(Object record, ZyUserParams example) {
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
		List<ZyArticle> articles = null;
		if (map != null) {
			articles = getSqlMapClientTemplate().queryForList(
					"zy_user.selectPaginationByPageNum", map);
		} else {
			return null;
		}
		return articles;
	}

	public int countPaginationByPageNum(Map<String, Object> map) {
		String m = "countPaginationByPageNum";
		int result = 0;
		if (map != null) {
			result = (Integer) getSqlMapClientTemplate().queryForObject(
					"zy_user.countPaginationByPageNum", map);
		} else {
			return 0;
		}
		return result;
	}
}