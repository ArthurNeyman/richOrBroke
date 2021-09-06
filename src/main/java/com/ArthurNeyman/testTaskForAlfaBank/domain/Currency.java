package com.ArthurNeyman.testTaskForAlfaBank.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties({"disclaimer", "license"})
public class Currency {

    @JsonProperty("rates")
    private Map<String, Float> rates;

    public Map<String, Float> getRates() {
        return rates;
    }
}
