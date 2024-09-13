package com.anakie.TestingAPI.backend.googleSearch.model.numberVerifierModel;

import lombok.NoArgsConstructor;


@NoArgsConstructor

//@JsonIgnoreProperties(ignoreUnknown = true)
public class CellNumber {
    private boolean success;
    private boolean valid;
    private String number;
    private String local_format;
    private String international_format;
    private String country_prefix;
    private String country_code;
    private String country_name;
    private String location;
    private String carrier;
    private String line_type;
    private Error error;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocal_format() {
        return local_format;
    }

    public void setLocal_format(String local_format) {
        this.local_format = local_format;
    }

    public String getInternational_format() {
        return international_format;
    }

    public void setInternational_format(String international_format) {
        this.international_format = international_format;
    }

    public String getCountry_prefix() {
        return country_prefix;
    }

    public void setCountry_prefix(String country_prefix) {
        this.country_prefix = country_prefix;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getLine_type() {
        return line_type;
    }

    public void setLine_type(String line_type) {
        this.line_type = line_type;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}