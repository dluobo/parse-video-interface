package org.apache.nutch.parse.html.video.database.model;

import java.util.ArrayList;
import java.util.List;

public class AreaCategoryTblExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public AreaCategoryTblExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAcIdIsNull() {
            addCriterion("ac_id is null");
            return (Criteria) this;
        }

        public Criteria andAcIdIsNotNull() {
            addCriterion("ac_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcIdEqualTo(Short value) {
            addCriterion("ac_id =", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotEqualTo(Short value) {
            addCriterion("ac_id <>", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdGreaterThan(Short value) {
            addCriterion("ac_id >", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ac_id >=", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdLessThan(Short value) {
            addCriterion("ac_id <", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdLessThanOrEqualTo(Short value) {
            addCriterion("ac_id <=", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdIn(List<Short> values) {
            addCriterion("ac_id in", values, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotIn(List<Short> values) {
            addCriterion("ac_id not in", values, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdBetween(Short value1, Short value2) {
            addCriterion("ac_id between", value1, value2, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotBetween(Short value1, Short value2) {
            addCriterion("ac_id not between", value1, value2, "acId");
            return (Criteria) this;
        }

        public Criteria andAcNameIsNull() {
            addCriterion("ac_name is null");
            return (Criteria) this;
        }

        public Criteria andAcNameIsNotNull() {
            addCriterion("ac_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcNameEqualTo(String value) {
            addCriterion("ac_name =", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotEqualTo(String value) {
            addCriterion("ac_name <>", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameGreaterThan(String value) {
            addCriterion("ac_name >", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameGreaterThanOrEqualTo(String value) {
            addCriterion("ac_name >=", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameLessThan(String value) {
            addCriterion("ac_name <", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameLessThanOrEqualTo(String value) {
            addCriterion("ac_name <=", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameLike(String value) {
            addCriterion("ac_name like", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotLike(String value) {
            addCriterion("ac_name not like", value, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameIn(List<String> values) {
            addCriterion("ac_name in", values, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotIn(List<String> values) {
            addCriterion("ac_name not in", values, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameBetween(String value1, String value2) {
            addCriterion("ac_name between", value1, value2, "acName");
            return (Criteria) this;
        }

        public Criteria andAcNameNotBetween(String value1, String value2) {
            addCriterion("ac_name not between", value1, value2, "acName");
            return (Criteria) this;
        }

        public Criteria andRelateAcidIsNull() {
            addCriterion("relate_acid is null");
            return (Criteria) this;
        }

        public Criteria andRelateAcidIsNotNull() {
            addCriterion("relate_acid is not null");
            return (Criteria) this;
        }

        public Criteria andRelateAcidEqualTo(Short value) {
            addCriterion("relate_acid =", value, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidNotEqualTo(Short value) {
            addCriterion("relate_acid <>", value, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidGreaterThan(Short value) {
            addCriterion("relate_acid >", value, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidGreaterThanOrEqualTo(Short value) {
            addCriterion("relate_acid >=", value, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidLessThan(Short value) {
            addCriterion("relate_acid <", value, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidLessThanOrEqualTo(Short value) {
            addCriterion("relate_acid <=", value, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidIn(List<Short> values) {
            addCriterion("relate_acid in", values, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidNotIn(List<Short> values) {
            addCriterion("relate_acid not in", values, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidBetween(Short value1, Short value2) {
            addCriterion("relate_acid between", value1, value2, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andRelateAcidNotBetween(Short value1, Short value2) {
            addCriterion("relate_acid not between", value1, value2, "relateAcid");
            return (Criteria) this;
        }

        public Criteria andIsPubIsNull() {
            addCriterion("is_pub is null");
            return (Criteria) this;
        }

        public Criteria andIsPubIsNotNull() {
            addCriterion("is_pub is not null");
            return (Criteria) this;
        }

        public Criteria andIsPubEqualTo(Boolean value) {
            addCriterion("is_pub =", value, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubNotEqualTo(Boolean value) {
            addCriterion("is_pub <>", value, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubGreaterThan(Boolean value) {
            addCriterion("is_pub >", value, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_pub >=", value, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubLessThan(Boolean value) {
            addCriterion("is_pub <", value, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubLessThanOrEqualTo(Boolean value) {
            addCriterion("is_pub <=", value, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubIn(List<Boolean> values) {
            addCriterion("is_pub in", values, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubNotIn(List<Boolean> values) {
            addCriterion("is_pub not in", values, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pub between", value1, value2, "isPub");
            return (Criteria) this;
        }

        public Criteria andIsPubNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pub not between", value1, value2, "isPub");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table area_category_tbl
     *
     * @mbggenerated do_not_delete_during_merge Fri Feb 01 15:11:41 CST 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table area_category_tbl
     *
     * @mbggenerated Fri Feb 01 15:11:41 CST 2013
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}