package com.example.MerchantService.domain;

import javax.persistence.Id;

public class Color {

    @Id
    private int colorId;
    private String colorName;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
