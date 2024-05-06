package com.vearc.insurance.database;

import com.vearc.insurance.bean.InsurancePolicy;

/*
* Helper class for formatting sql queries
* */
public class QueryHelper {

    public static String getSaveQuery(InsurancePolicy policy) {
        String query = "insert into %s (%s, %s, %s, %s, %s, %s, %s) " +
                "values (%s, %s, %s, %s, %s, %s, %s)";
        return String.format(query,
                InsurancePolicy.getTableName("xyz"), //dummy tenantID for now
                TableColumns.name, TableColumns.id, TableColumns.status, TableColumns.coverageBegin, TableColumns.coverageEnd, TableColumns.createdDate, TableColumns.modifiedDate,
                policy.getName(), policy.getId(), policy.getStatus(), policy.getCoverageBeginDate(), policy.getCoverageEndDate(), policy.getCreatedDate(), policy.getModifiedDate());
    }

    public static String getUpdateQuery(InsurancePolicy policy) {
        String query = "update %s set  %s = %s, %s = %s, %s = %s, %s = %s, %s = %s, %s = %s where %s = %s";
        return String.format(query,
                InsurancePolicy.getTableName("xyz"), //dummy tenantID
                TableColumns.name, policy.getName(),
                TableColumns.modifiedDate, policy.getModifiedDate(),
                TableColumns.createdDate, policy.getCreatedDate(),
                TableColumns.coverageBegin, policy.getCoverageBeginDate(),
                TableColumns.coverageEnd, policy.getCoverageEndDate(),
                TableColumns.status, policy.getStatus(),
                //upadte key
                TableColumns.id, policy.getId());
    }

    public static String getSelectPolicyQueryUsingId(int id) {
        String query = "select * from %s where %s = '%s'";
        return String.format(query,
                InsurancePolicy.getTableName("xuz"), //dummy tenantID
                TableColumns.id,
                id);
    }

    public static String getSelectQueryUsingName(String name) {
        String query = "select * from %s where %s = '%s'";
        return String.format(query,
                InsurancePolicy.getTableName("xyz"),
                TableColumns.name,
                name);
    }

    public static class TableColumns {
        static final String name = "name";
        static final String id = "id";
        static final String status = "status";
        static final String coverageBegin = "coverage_begin_date";
        static final String coverageEnd = "coverage_end_date";
        static final String createdDate = "created_date";
        static final String modifiedDate = "modified_date";
    }
}
