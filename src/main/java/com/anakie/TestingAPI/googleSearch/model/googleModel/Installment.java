package com.anakie.TestingAPI.googleSearch.model.googleModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Installment {
    @JsonProperty("down_payment")
    private String downPayment;

    @JsonProperty("extracted_down_payment")
    private int extractedDownPayment;

    @JsonProperty("months")
    private String months;

    @JsonProperty("extracted_months")
    private int extractedMonths;

    @JsonProperty("cost_per_month")
    private String costPerMonth;

    @JsonProperty("extracted_cost_per_month")
    private double extractedCostPerMonth;

    // Constructors, getters, and setters
}
