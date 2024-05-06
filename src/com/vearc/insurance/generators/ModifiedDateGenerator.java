package com.vearc.insurance.generators;

import com.vearc.insurance.bean.InsurancePolicy;

import java.util.Date;

public class ModifiedDateGenerator implements PolicyAttributeGenerator {

    @Override
    public void generateAttributeValue(InsurancePolicy policy) {
        policy.setModifiedDate(new Date());
    }
}
