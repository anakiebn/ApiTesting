package com.anakie.TestingAPI.backend.googleSearch.model.googleModel;

import lombok.Data;

@Data
public class ShoppingAd {

    private int position;
    private String title;
    private String price;
    private int extracted_price;
    private String link;
    private String seller;
    private String delivery;
    private Installment installment;
    private String thumbnail;
}
