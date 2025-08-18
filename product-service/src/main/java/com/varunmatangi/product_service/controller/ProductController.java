package com.varunmatangi.product_service.controller;

import com.varunmatangi.product_service.dto.AddProductRequestDTO;
import com.varunmatangi.product_service.dto.ProductResponseDTO;
import com.varunmatangi.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/id/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable String productId) {
        return new ResponseEntity<>(productService.getProductByProductId(productId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody AddProductRequestDTO addProductRequestDTO) {
        return new ResponseEntity<>(productService.addProduct(addProductRequestDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{productId}/reduceStock")
    public ResponseEntity<Void> reduceStock(@PathVariable String productId, @RequestParam int quantity){
        productService.reduceStock(productId,quantity);
        return ResponseEntity.ok().build();
    }

}
