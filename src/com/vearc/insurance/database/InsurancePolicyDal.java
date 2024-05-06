package com.vearc.insurance.database;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyDal {

    InsurancePolicy getPolicyByID(int id);

    List<InsurancePolicy> getPoliciesByName(String name);

    InsurancePolicy save(InsurancePolicy policy);

    InsurancePolicy update(InsurancePolicy policy);
}
