package com.vearc.insurance.validators;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.List;

public class StatusValidator implements PolicyAttributeValidator {

    @Override
    public void validate(InsurancePolicy policy, List<String> errors) {
        if (policy.getStatus() == null) {
            errors.add("Policy status is null");
        }
    }
}
