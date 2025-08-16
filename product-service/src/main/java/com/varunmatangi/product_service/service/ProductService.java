package com.varunmatangi.product_service.service;

import com.varunmatangi.product_service.dto.AddProductRequestDTO;
import com.varunmatangi.product_service.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO getProductByProductId(String productId);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO addProduct(AddProductRequestDTO addProductRequestDTO);
}
