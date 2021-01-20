package com.example.MerchantService.feignclient;


import com.example.MerchantService.domain.Inventory;
import com.example.MerchantService.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "ProductService", url = "http://localhost:9093/")
public interface ProductClient {

    @GetMapping(value = "/products/{productid}")
    public Product getProductById(@PathVariable("productid")String productid);

    @PutMapping(value="/inventory/update")
    public Inventory updateInventory(@RequestBody Inventory inventory);

    @DeleteMapping("/inventory/remove/{productid}/{merchantid}/{colorid}/{sizeid}")
    public ResponseEntity deleteInventoryByKey(@PathVariable("productid") String product, @PathVariable("merchantid") String merchantid, @PathVariable("colorid") int colorid, @PathVariable("sizeid") int sizeid);

    @GetMapping(value = "/inventory/count/{merchant_id}")
    public int getProductCountByMerchantId(@PathVariable("merchant_id")String merchant_id);

    @PostMapping("/inventory/add")
    public ResponseEntity addInventory(@RequestBody Inventory inventory);

    @GetMapping("/inventory/stock/{merchant_id}/{product_id}")
    public int getQuantityOfProductByMerchantId(@PathVariable("merchant_id") String merchant_id,@PathVariable("product_id") String product_id);
}
