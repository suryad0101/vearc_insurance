package com.vearc.insurance.bean;

import java.util.Date;

/*
* Class which is used by upstream layer for save/update policy requests
* This dto get translated of actual insurance bean in the service layer
* */
public class InsurancePolicyRequestDto {

    private String name;
    private PolicyStatus status;
    private Date coverageBeginDate;
    private Date coverageEndDate;


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
}
