package com.vearc.insurance.service;

import com.vearc.insurance.bean.InsurancePolicy;
import com.vearc.insurance.bean.InsurancePolicyRequestDto;

import java.util.List;
import java.util.Optional;

public interface InsurancePolicyService {

    List<InsurancePolicy> listPoliciesByName(String name);

    Optional<InsurancePolicy> getPolicyById(int id);

    Optional<InsurancePolicy> createPolicy(InsurancePolicyRequestDto policy);

    Optional<InsurancePolicy> updatePolicy(int id, InsurancePolicyRequestDto policy);
}
