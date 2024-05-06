package com.vearc.insurance.generators;

import com.vearc.insurance.bean.InsurancePolicy;

/*
* common generator interface for {@code InsurancePolicy} sysetm properties
* */
public interface PolicyAttributeGenerator {

    void generateAttributeValue(InsurancePolicy policy);
}
