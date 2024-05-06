package com.vearc.insurance.validators;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.Date;
import java.util.List;

public class CoveragePeriodValidator implements PolicyAttributeValidator {

    @Override
    public void validate(InsurancePolicy policy, List<String> errors) {
        if (policy.getCoverageBeginDate() == null) {
            errors.add("Coverage begin date is required");
        }
        if (policy.getCoverageEndDate() == null) {
            errors.add("Coverage end date is required");
        }
        Date startDate = policy.getCoverageBeginDate();
        Date endDate = policy.getCoverageEndDate();
        if (startDate.after(endDate)) {
            errors.add("Coverage begin date is after end date");
        }
    }
}
