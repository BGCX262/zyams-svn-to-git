package com.zhiye.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZyMsgParams {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public ZyMsgParams() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    protected ZyMsgParams(ZyMsgParams example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
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
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table zy_msg
     *
     * @abatorgenerated Thu Apr 26 20:58:31 CST 2012
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

        public Criteria andMsgidIsNull() {
            addCriterion("msgId is null");
            return this;
        }

        public Criteria andMsgidIsNotNull() {
            addCriterion("msgId is not null");
            return this;
        }

        public Criteria andMsgidEqualTo(Long value) {
            addCriterion("msgId =", value, "msgId");
            return this;
        }

        public Criteria andMsgidNotEqualTo(Long value) {
            addCriterion("msgId <>", value, "msgId");
            return this;
        }

        public Criteria andMsgidGreaterThan(Long value) {
            addCriterion("msgId >", value, "msgId");
            return this;
        }

        public Criteria andMsgidGreaterThanOrEqualTo(Long value) {
            addCriterion("msgId >=", value, "msgId");
            return this;
        }

        public Criteria andMsgidLessThan(Long value) {
            addCriterion("msgId <", value, "msgId");
            return this;
        }

        public Criteria andMsgidLessThanOrEqualTo(Long value) {
            addCriterion("msgId <=", value, "msgId");
            return this;
        }

        public Criteria andMsgidIn(List values) {
            addCriterion("msgId in", values, "msgId");
            return this;
        }

        public Criteria andMsgidNotIn(List values) {
            addCriterion("msgId not in", values, "msgId");
            return this;
        }

        public Criteria andMsgidBetween(Long value1, Long value2) {
            addCriterion("msgId between", value1, value2, "msgId");
            return this;
        }

        public Criteria andMsgidNotBetween(Long value1, Long value2) {
            addCriterion("msgId not between", value1, value2, "msgId");
            return this;
        }
        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("userId =", value, "userId");
            return this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("userId >", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("userId <", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userId");
            return this;
        }

        public Criteria andUserIdIn(List values) {
            addCriterion("userId in", values, "userId");
            return this;
        }

        public Criteria andUserIdNotIn(List values) {
            addCriterion("userId not in", values, "userId");
            return this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userId");
            return this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return this;
        }
        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return this;
        }

        public Criteria andUsernameIn(List values) {
            addCriterion("userName in", values, "username");
            return this;
        }

        public Criteria andUsernameNotIn(List values) {
            addCriterion("userName not in", values, "username");
            return this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return this;
        }

        public Criteria andEmailIn(List values) {
            addCriterion("email in", values, "email");
            return this;
        }

        public Criteria andEmailNotIn(List values) {
            addCriterion("email not in", values, "email");
            return this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return this;
        }

        public Criteria andMobileIn(List values) {
            addCriterion("mobile in", values, "mobile");
            return this;
        }

        public Criteria andMobileNotIn(List values) {
            addCriterion("mobile not in", values, "mobile");
            return this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return this;
        }

        public Criteria andGenderIn(List values) {
            addCriterion("gender in", values, "gender");
            return this;
        }

        public Criteria andGenderNotIn(List values) {
            addCriterion("gender not in", values, "gender");
            return this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
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
    }
}