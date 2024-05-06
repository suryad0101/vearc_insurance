package com.vearc.insurance.validators;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.List;

/*
* Common validator chain interface for {@code InsurancePolicy} properties
* */
public interface PolicyAttributeValidator {

    void validate(InsurancePolicy policy, List<String> errors);
}
