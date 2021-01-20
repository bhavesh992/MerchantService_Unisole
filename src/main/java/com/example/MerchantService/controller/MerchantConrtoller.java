package com.example.MerchantService.controller;

import com.example.MerchantService.domain.Inventory;
import com.example.MerchantService.domain.JwtToken;
import com.example.MerchantService.domain.RatingData;
import com.example.MerchantService.domain.User;
import com.example.MerchantService.entity.MerchantStore;
import com.example.MerchantService.feignclient.LoginClient;
import com.example.MerchantService.feignclient.ProductClient;
import com.example.MerchantService.services.MerchantRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/merchants")
public class MerchantConrtoller {

    @Autowired
    ProductClient productClient;
    @Autowired
    LoginClient loginClient;

    @Autowired
    MerchantRegistrationService merchantRegistrationService;
    @GetMapping("/products/{productid}")
    public ResponseEntity getProductByCategory(@PathVariable("productid") String category)
    {
        return new ResponseEntity(productClient.getProductById(category),HttpStatus.OK);
    }
    @PutMapping("/inventory/update")
    public ResponseEntity updateStock(@RequestBody Inventory inventory)
    {
        return new ResponseEntity(productClient.updateInventory(inventory),HttpStatus.OK);
    }

    @DeleteMapping("/inventory/remove/{productid}/{merchantid}/{colorid}/{sizeid}")
    public ResponseEntity deleteInventoryByKey(@PathVariable("productid") String product,@PathVariable("merchantid") String merchantid,@PathVariable("colorid") int colorid,@PathVariable("sizeid") int sizeid)
    {
        return new ResponseEntity(productClient.deleteInventoryByKey(product, merchantid, colorid, sizeid),HttpStatus.OK);
    }

    @GetMapping("/inventory/count/{merchant_id}")
    public ResponseEntity getProductCountByMerchantId(@PathVariable("merchant_id") String merchantId)
    {
        return new ResponseEntity(productClient.getProductCountByMerchantId(merchantId),HttpStatus.OK);
    }
    @PostMapping("/inventory/add")
    public ResponseEntity addInventory(@RequestBody Inventory inventory)
    {
        return new ResponseEntity(productClient.addInventory(inventory),HttpStatus.OK);
    }

    @GetMapping("/inventory/stock/{merchant_id}/{product_id}")
    public ResponseEntity getQuantityOfProductByMerchantId(@PathVariable("merchant_id") String merchant_id,@PathVariable("product_id") String product_id)
    {
        return new ResponseEntity(productClient.getQuantityOfProductByMerchantId(merchant_id, product_id),HttpStatus.OK);
    }
    @PostMapping("/user/signup/{roleId}")
    public ResponseEntity signup(@RequestBody User user, @PathVariable("roleId") int roleId)
    {
        try
        {
            System.out.println("Called");

            return new ResponseEntity<>(loginClient.signup(user,roleId),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity getMerchantById(@RequestBody MerchantStore merchantStore)
    {
        try
        {
            return new ResponseEntity<>(merchantRegistrationService.registerStore(merchantStore),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{merchant_id}")
    public ResponseEntity getMerchantById(@PathVariable("merchant_id") String merchant_id)
    {
        try
        {
            return new ResponseEntity<>(merchantRegistrationService.getMerchantStoreById(merchant_id),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updaterating")
    public ResponseEntity updateRating(@RequestBody RatingData ratingData)
    {
            try
            {
                merchantRegistrationService.updateRating(ratingData.getMerchantId(),ratingData.getRating());
                return new ResponseEntity(new JwtToken("Rating Updated"),HttpStatus.OK);
            }
            catch(Exception e)
            {

                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
    }


}
