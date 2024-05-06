package com.vearc.insurance.generators;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.Date;

public class CreatedDateGenerator implements PolicyAttributeGenerator {

    @Override
    public void generateAttributeValue(InsurancePolicy policy) {
        policy.setCreatedDate(new Date());
    }
}
