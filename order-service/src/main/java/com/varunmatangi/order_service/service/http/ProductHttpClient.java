package com.varunmatangi.order_service.service.http;

import com.varunmatangi.order_service.dto.ProductResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PutExchange;


public interface ProductHttpClient {

    @GetExchange("/id/{productId}")
    ProductResponseDTO getProductById(@PathVariable String productId);

    @PutExchange("/{productId}/reduceStock")
    void reduceStock(@PathVariable String productId, @RequestParam int quantity);
}
