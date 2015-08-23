package com.zhiye.common.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZyPartmentParams {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public ZyPartmentParams() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    protected ZyPartmentParams(ZyPartmentParams example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
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
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table zy_partment
     *
     * @abatorgenerated Fri Mar 23 14:39:06 CST 2012
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

        public Criteria andPartmentIdIsNull() {
            addCriterion("partmentId is null");
            return this;
        }

        public Criteria andPartmentIdIsNotNull() {
            addCriterion("partmentId is not null");
            return this;
        }

        public Criteria andPartmentIdEqualTo(Integer value) {
            addCriterion("partmentId =", value, "partmentId");
            return this;
        }

        public Criteria andPartmentIdNotEqualTo(Integer value) {
            addCriterion("partmentId <>", value, "partmentId");
            return this;
        }

        public Criteria andPartmentIdGreaterThan(Integer value) {
            addCriterion("partmentId >", value, "partmentId");
            return this;
        }

        public Criteria andPartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("partmentId >=", value, "partmentId");
            return this;
        }

        public Criteria andPartmentIdLessThan(Integer value) {
            addCriterion("partmentId <", value, "partmentId");
            return this;
        }

        public Criteria andPartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("partmentId <=", value, "partmentId");
            return this;
        }

        public Criteria andPartmentIdIn(List values) {
            addCriterion("partmentId in", values, "partmentId");
            return this;
        }

        public Criteria andPartmentIdNotIn(List values) {
            addCriterion("partmentId not in", values, "partmentId");
            return this;
        }

        public Criteria andPartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("partmentId between", value1, value2, "partmentId");
            return this;
        }

        public Criteria andPartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("partmentId not between", value1, value2, "partmentId");
            return this;
        }

        public Criteria andPartmentNameIsNull() {
            addCriterion("partment_name is null");
            return this;
        }

        public Criteria andPartmentNameIsNotNull() {
            addCriterion("partment_name is not null");
            return this;
        }

        public Criteria andPartmentNameEqualTo(String value) {
            addCriterion("partment_name =", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameNotEqualTo(String value) {
            addCriterion("partment_name <>", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameGreaterThan(String value) {
            addCriterion("partment_name >", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("partment_name >=", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameLessThan(String value) {
            addCriterion("partment_name <", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameLessThanOrEqualTo(String value) {
            addCriterion("partment_name <=", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameLike(String value) {
            addCriterion("partment_name like", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameNotLike(String value) {
            addCriterion("partment_name not like", value, "partmentName");
            return this;
        }

        public Criteria andPartmentNameIn(List values) {
            addCriterion("partment_name in", values, "partmentName");
            return this;
        }

        public Criteria andPartmentNameNotIn(List values) {
            addCriterion("partment_name not in", values, "partmentName");
            return this;
        }

        public Criteria andPartmentNameBetween(String value1, String value2) {
            addCriterion("partment_name between", value1, value2, "partmentName");
            return this;
        }

        public Criteria andPartmentNameNotBetween(String value1, String value2) {
            addCriterion("partment_name not between", value1, value2, "partmentName");
            return this;
        }
    }
}