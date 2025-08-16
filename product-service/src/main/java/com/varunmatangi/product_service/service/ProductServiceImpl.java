package com.varunmatangi.product_service.service;

import com.varunmatangi.product_service.dto.AddProductRequestDTO;
import com.varunmatangi.product_service.dto.ProductResponseDTO;
import com.varunmatangi.product_service.entity.Product;
import com.varunmatangi.product_service.exception.ProductNotFoundException;
import com.varunmatangi.product_service.mapper.ProductMapper;
import com.varunmatangi.product_service.reposiotry.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;


    private Product findProductById(String productId) {
        return productRepo.findById(productId).orElseThrow(()-> new ProductNotFoundException("Product Not found with ID "+ productId,"PRODUCT_NOT_FOUND"));
    }

    @Override
    public ProductResponseDTO getProductByProductId(String productId) {
        Product product = findProductById(productId);
        return productMapper.productToProductResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(productMapper::productToProductResponseDTO).toList();
    }

    @Override
    public ProductResponseDTO addProduct(AddProductRequestDTO addProductRequestDTO) {
        Product product = productRepo.save(productMapper.addProductDTOtoProduct(addProductRequestDTO));
        return productMapper.productToProductResponseDTO(product);
    }
}
