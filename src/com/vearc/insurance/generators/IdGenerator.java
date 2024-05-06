package com.vearc.insurance.generators;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.UUID;

public class IdGenerator implements PolicyAttributeGenerator {

    @Override
    public void generateAttributeValue(InsurancePolicy policy) {
        policy.setId(Math.abs(UUID.randomUUID().hashCode()));
    }
}
