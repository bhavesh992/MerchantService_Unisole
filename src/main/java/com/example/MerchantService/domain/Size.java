package com.example.MerchantService.domain;

import javax.persistence.Id;

public class Size {

    @Id
    private int sizeId;
    private int sizeNumber;

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getSizeNumber() {
        return sizeNumber;
    }

    public void setSizeNumber(int sizeNumber) {
        this.sizeNumber = sizeNumber;
    }
}
