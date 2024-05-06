package com.vearc.insurance.validators;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.List;

public class NameValidator implements PolicyAttributeValidator {

    @Override
    public void validate(InsurancePolicy policy, List<String> errors) {
        String name = policy.getName();
        if (name == null || name.isEmpty()) {
            errors.add("Name is empty");
        } else if (name.length() > 255) {
            errors.add("Name is too long");
        }
    }
}
