package com.zhiye.dao;

import java.util.List;

import com.zhiye.common.bean.ZySite;


public class ZySiteDAOImpl  extends CommonDAO  implements ZySiteDAO {

	
    public ZySiteDAOImpl() {
        super();
    }
	public long countAllRecords() {  
		Long count = (Long)  getSqlMapClientTemplate().queryForObject("zy_site.countAllRecords");
		return count;
	}

	public int deleteByParams(long key1) {
		ZySite key = new ZySite();
        key.setId(key1);
        int rows = getSqlMapClientTemplate().delete("zy_site.deleteByPrimaryKey", key);
        return rows;
	}

	public void insert(ZySite record) {
		getSqlMapClientTemplate().insert("zy_site.insert", record);
	}

	public ZySite selectByPrimaryKey(Long siteId) {
		 ZySite record = (ZySite) getSqlMapClientTemplate().queryForObject("zy_site.selectByPrimaryKey", siteId);
	        return record;
	}

	public int updateByPrimaryKey(ZySite record) {
		 int rows = getSqlMapClientTemplate().update("zy_site.updateByPrimaryKey", record);
	        return rows;
	}
	@SuppressWarnings("unchecked")
	public List<ZySite> selectByIP(String ip) {
		ZySite key = new ZySite();
        key.setIp(ip);
        return (List<ZySite> )getSqlMapClientTemplate().queryForList("zy_site.selectByIP", key);
        
	}


}