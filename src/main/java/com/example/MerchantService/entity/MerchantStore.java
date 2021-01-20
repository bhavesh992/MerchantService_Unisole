package com.example.MerchantService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="merchant")
public class MerchantStore {

    @Id
    private String email;
    private String merchantStoreName;
    private int merchantRating;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMerchantStoreName() {
        return merchantStoreName;
    }

    public void setMerchantStoreName(String merchantStoreName) {
        this.merchantStoreName = merchantStoreName;
    }

    public int getMerchantRating() {
        return merchantRating;
    }

    public void setMerchantRating(int merchantRating) {
        this.merchantRating = merchantRating;
    }
}
