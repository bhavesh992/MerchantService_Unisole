package com.example.MerchantService.repository;

import com.example.MerchantService.entity.MerchantStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MerchantRepository extends JpaRepository<MerchantStore,String> {

    @Transactional
    @Modifying
    @Query(value="update merchant set  merchant_rating=:value where email=:merchantId",nativeQuery = true)
    void updateMerchantRating(@Param("value") double value,@Param("merchantId") String merchantId);
}
