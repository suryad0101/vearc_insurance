package com.vearc.insurance.service;

import com.vearc.insurance.bean.InsurancePolicy;
import com.vearc.insurance.bean.InsurancePolicyRequestDto;
import com.vearc.insurance.database.InsurancePolicyDalImpl;
import com.vearc.insurance.util.CommonUtils;
import com.vearc.insurance.validators.CoveragePeriodValidator;
import com.vearc.insurance.validators.NameValidator;
import com.vearc.insurance.validators.PolicyAttributeValidator;
import com.vearc.insurance.validators.StatusValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* Service layer for all the read and write operations of {@code InsurancePolicy}
* */
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    private static final List<PolicyAttributeValidator> validators = new ArrayList<>();

    static {
        validators.add(new NameValidator());
        validators.add(new StatusValidator());
        validators.add(new CoveragePeriodValidator());
    }

    @Override
    public List<InsurancePolicy> listPoliciesByName(String name) {
        return new InsurancePolicyDalImpl().getPoliciesByName(name);
    }

    @Override
    public Optional<InsurancePolicy> getPolicyById(int id) {
        InsurancePolicy policy = new InsurancePolicyDalImpl().getPolicyByID(id);
        return Optional.ofNullable(policy);
    }

    @Override
    public Optional<InsurancePolicy> createPolicy(InsurancePolicyRequestDto requestDto) {
        InsurancePolicy requestPolicy = CommonUtils.buildPolicyFromRequestDto(requestDto);
        List<String> errors = new ArrayList<>();
        validators.forEach(validator -> validator.validate(requestPolicy, errors));
        if (!errors.isEmpty()) {
            //log errors
            throw new RuntimeException("Request validation errors: " + String.join(";", errors));
        }
        return Optional.ofNullable(new InsurancePolicyDalImpl().save(requestPolicy));
    }

    @Override
    public Optional<InsurancePolicy> updatePolicy(int id, InsurancePolicyRequestDto policy) {
        InsurancePolicy policyFromDb = new InsurancePolicyDalImpl().getPolicyByID(id);
        if (policyFromDb == null || policyFromDb.getId() != id) {
            System.out.println("Invalid insurance id. No record found.");
            return Optional.empty();
        }
        InsurancePolicy updatedPolicy = CommonUtils.updatePolicyFromRequestDto(policyFromDb, policy);
        List<String> errors = new ArrayList<>();
        validators.forEach(validator -> validator.validate(updatedPolicy, errors));
        if (!errors.isEmpty()) {
            //log errors
            throw new RuntimeException("Request validation errors: " + String.join(";", errors));
        }
        InsurancePolicy finalPolicy = new InsurancePolicyDalImpl().update(updatedPolicy);
        return Optional.ofNullable(finalPolicy);
    }
}
