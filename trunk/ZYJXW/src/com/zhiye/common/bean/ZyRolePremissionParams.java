package com.zhiye.common.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZyRolePremissionParams {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public ZyRolePremissionParams() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    protected ZyRolePremissionParams(ZyRolePremissionParams example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
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
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table zy_role_premission
     *
     * @abatorgenerated Fri Mar 23 14:39:07 CST 2012
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return this;
        }

        public Criteria andRoleIdIn(List values) {
            addCriterion("role_id in", values, "roleId");
            return this;
        }

        public Criteria andRoleIdNotIn(List values) {
            addCriterion("role_id not in", values, "roleId");
            return this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return this;
        }

        public Criteria andPremissionIdIsNull() {
            addCriterion("premission_id is null");
            return this;
        }

        public Criteria andPremissionIdIsNotNull() {
            addCriterion("premission_id is not null");
            return this;
        }

        public Criteria andPremissionIdEqualTo(Integer value) {
            addCriterion("premission_id =", value, "premissionId");
            return this;
        }

        public Criteria andPremissionIdNotEqualTo(Integer value) {
            addCriterion("premission_id <>", value, "premissionId");
            return this;
        }

        public Criteria andPremissionIdGreaterThan(Integer value) {
            addCriterion("premission_id >", value, "premissionId");
            return this;
        }

        public Criteria andPremissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("premission_id >=", value, "premissionId");
            return this;
        }

        public Criteria andPremissionIdLessThan(Integer value) {
            addCriterion("premission_id <", value, "premissionId");
            return this;
        }

        public Criteria andPremissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("premission_id <=", value, "premissionId");
            return this;
        }

        public Criteria andPremissionIdIn(List values) {
            addCriterion("premission_id in", values, "premissionId");
            return this;
        }

        public Criteria andPremissionIdNotIn(List values) {
            addCriterion("premission_id not in", values, "premissionId");
            return this;
        }

        public Criteria andPremissionIdBetween(Integer value1, Integer value2) {
            addCriterion("premission_id between", value1, value2, "premissionId");
            return this;
        }

        public Criteria andPremissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("premission_id not between", value1, value2, "premissionId");
            return this;
        }
    }
}