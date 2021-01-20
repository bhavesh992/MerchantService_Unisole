package com.example.MerchantService.services.impl;

import com.example.MerchantService.entity.MerchantStore;
import com.example.MerchantService.repository.MerchantRepository;
import com.example.MerchantService.services.MerchantRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantRegistrationServiceImpl implements MerchantRegistrationService {
    @Autowired
    MerchantRepository merchantRepository;
    @Override
    public MerchantStore registerStore(MerchantStore merchantStore) {
        return merchantRepository.save(merchantStore);
    }

    @Override
    public MerchantStore getMerchantStoreById(String merchantId) {
        return merchantRepository.findById(merchantId).get();
    }

    @Override
    public void updateRating(String merchant_id,double rating) {
        merchantRepository.updateMerchantRating(rating,merchant_id);
    }
}
