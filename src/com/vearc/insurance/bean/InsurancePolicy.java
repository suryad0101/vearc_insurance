package com.vearc.insurance.bean;

import java.util.Date;
import java.util.Objects;

/*
* Actual bean whose values are translated and stored in db
* */

public class InsurancePolicy {

    /*
    * custom fields
    * values will be set in the com.java.vearc.service/api layer
    * */
    private String name;
    private PolicyStatus status;
    private Date coverageBeginDate;
    private Date coverageEndDate;

    /*
     * system fields
     * values will be set in the DAO layer
     * */
    private int id;
    private Date createdDate;
    private Date modifiedDate;


    /*
    * tenantId for multi-tenant architecture
    * */
    public static String getTableName(String tenantId) {
        return "insurance_policy_" + tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public Date getCoverageBeginDate() {
        return coverageBeginDate;
    }

    public void setCoverageBeginDate(Date coverageBeginDate) {
        this.coverageBeginDate = coverageBeginDate;
    }

    public Date getCoverageEndDate() {
        return coverageEndDate;
    }

    public void setCoverageEndDate(Date coverageEndDate) {
        this.coverageEndDate = coverageEndDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", coverageBeginDate=" + coverageBeginDate +
                ", coverageEndDate=" + coverageEndDate +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
