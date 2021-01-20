package com.example.MerchantService.services;

import com.example.MerchantService.entity.MerchantStore;

public interface MerchantRegistrationService
{
    MerchantStore registerStore(MerchantStore merchantStore);
    MerchantStore getMerchantStoreById(String merchantId);
    void updateRating(String merchant_id,double rating);
}
