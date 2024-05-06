package com.vearc.insurance.util;

import com.vearc.insurance.bean.InsurancePolicy;
import com.vearc.insurance.bean.InsurancePolicyRequestDto;

import java.util.Date;

/*
* Helper class for misc functions
* */
public class CommonUtils {

    public static InsurancePolicy buildPolicyFromRequestDto(InsurancePolicyRequestDto requestDto) {
        InsurancePolicy policy = new InsurancePolicy();
        policy.setName(requestDto.getName());
        policy.setStatus(requestDto.getStatus());
        policy.setCoverageBeginDate(requestDto.getCoverageBeginDate());
        policy.setCoverageEndDate(requestDto.getCoverageEndDate());
        return policy;
    }

    public static InsurancePolicy updatePolicyFromRequestDto(InsurancePolicy policy, InsurancePolicyRequestDto requestDto) {
        policy.setStatus(requestDto.getStatus());
        policy.setCoverageBeginDate(requestDto.getCoverageBeginDate());
        policy.setCoverageEndDate(requestDto.getCoverageEndDate());
        policy.setName(policy.getName());
        //
        policy.setModifiedDate(new Date());
        return policy;
    }
}
