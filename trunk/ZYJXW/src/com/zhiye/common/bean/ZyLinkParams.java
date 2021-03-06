package com.zhiye.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZyLinkParams {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public ZyLinkParams() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    protected ZyLinkParams(ZyLinkParams example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table zy_link
     *
     * @abatorgenerated Mon Apr 16 20:03:39 CST 2012
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andLinkidIsNull() {
            addCriterion("linkId is null");
            return this;
        }

        public Criteria andLinkidIsNotNull() {
            addCriterion("linkId is not null");
            return this;
        }

        public Criteria andLinkidEqualTo(Integer value) {
            addCriterion("linkId =", value, "linkid");
            return this;
        }

        public Criteria andLinkidNotEqualTo(Integer value) {
            addCriterion("linkId <>", value, "linkid");
            return this;
        }

        public Criteria andLinkidGreaterThan(Integer value) {
            addCriterion("linkId >", value, "linkid");
            return this;
        }

        public Criteria andLinkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("linkId >=", value, "linkid");
            return this;
        }

        public Criteria andLinkidLessThan(Integer value) {
            addCriterion("linkId <", value, "linkid");
            return this;
        }

        public Criteria andLinkidLessThanOrEqualTo(Integer value) {
            addCriterion("linkId <=", value, "linkid");
            return this;
        }

        public Criteria andLinkidIn(List values) {
            addCriterion("linkId in", values, "linkid");
            return this;
        }

        public Criteria andLinkidNotIn(List values) {
            addCriterion("linkId not in", values, "linkid");
            return this;
        }

        public Criteria andLinkidBetween(Integer value1, Integer value2) {
            addCriterion("linkId between", value1, value2, "linkid");
            return this;
        }

        public Criteria andLinkidNotBetween(Integer value1, Integer value2) {
            addCriterion("linkId not between", value1, value2, "linkid");
            return this;
        }

        public Criteria andLinknameIsNull() {
            addCriterion("linkName is null");
            return this;
        }

        public Criteria andLinknameIsNotNull() {
            addCriterion("linkName is not null");
            return this;
        }

        public Criteria andLinknameEqualTo(String value) {
            addCriterion("linkName =", value, "linkname");
            return this;
        }

        public Criteria andLinknameNotEqualTo(String value) {
            addCriterion("linkName <>", value, "linkname");
            return this;
        }

        public Criteria andLinknameGreaterThan(String value) {
            addCriterion("linkName >", value, "linkname");
            return this;
        }

        public Criteria andLinknameGreaterThanOrEqualTo(String value) {
            addCriterion("linkName >=", value, "linkname");
            return this;
        }

        public Criteria andLinknameLessThan(String value) {
            addCriterion("linkName <", value, "linkname");
            return this;
        }

        public Criteria andLinknameLessThanOrEqualTo(String value) {
            addCriterion("linkName <=", value, "linkname");
            return this;
        }

        public Criteria andLinknameLike(String value) {
            addCriterion("linkName like", value, "linkname");
            return this;
        }

        public Criteria andLinknameNotLike(String value) {
            addCriterion("linkName not like", value, "linkname");
            return this;
        }

        public Criteria andLinknameIn(List values) {
            addCriterion("linkName in", values, "linkname");
            return this;
        }

        public Criteria andLinknameNotIn(List values) {
            addCriterion("linkName not in", values, "linkname");
            return this;
        }

        public Criteria andLinknameBetween(String value1, String value2) {
            addCriterion("linkName between", value1, value2, "linkname");
            return this;
        }

        public Criteria andLinknameNotBetween(String value1, String value2) {
            addCriterion("linkName not between", value1, value2, "linkname");
            return this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeIn(List values) {
            addCriterion("createTime in", values, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotIn(List values) {
            addCriterion("createTime not in", values, "createtime");
            return this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return this;
        }

        public Criteria andLinktypeIsNull() {
            addCriterion("linkType is null");
            return this;
        }

        public Criteria andLinktypeIsNotNull() {
            addCriterion("linkType is not null");
            return this;
        }

        public Criteria andLinktypeEqualTo(String value) {
            addCriterion("linkType =", value, "linktype");
            return this;
        }

        public Criteria andLinktypeNotEqualTo(String value) {
            addCriterion("linkType <>", value, "linktype");
            return this;
        }

        public Criteria andLinktypeGreaterThan(String value) {
            addCriterion("linkType >", value, "linktype");
            return this;
        }

        public Criteria andLinktypeGreaterThanOrEqualTo(String value) {
            addCriterion("linkType >=", value, "linktype");
            return this;
        }

        public Criteria andLinktypeLessThan(String value) {
            addCriterion("linkType <", value, "linktype");
            return this;
        }

        public Criteria andLinktypeLessThanOrEqualTo(String value) {
            addCriterion("linkType <=", value, "linktype");
            return this;
        }

        public Criteria andLinktypeLike(String value) {
            addCriterion("linkType like", value, "linktype");
            return this;
        }

        public Criteria andLinktypeNotLike(String value) {
            addCriterion("linkType not like", value, "linktype");
            return this;
        }

        public Criteria andLinktypeIn(List values) {
            addCriterion("linkType in", values, "linktype");
            return this;
        }

        public Criteria andLinktypeNotIn(List values) {
            addCriterion("linkType not in", values, "linktype");
            return this;
        }

        public Criteria andLinktypeBetween(String value1, String value2) {
            addCriterion("linkType between", value1, value2, "linktype");
            return this;
        }

        public Criteria andLinktypeNotBetween(String value1, String value2) {
            addCriterion("linkType not between", value1, value2, "linktype");
            return this;
        }
    }
}