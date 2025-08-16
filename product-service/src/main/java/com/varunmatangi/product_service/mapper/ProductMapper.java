package com.varunmatangi.product_service.mapper;

import com.varunmatangi.product_service.dto.AddProductRequestDTO;
import com.varunmatangi.product_service.dto.ProductResponseDTO;
import com.varunmatangi.product_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product addProductDTOtoProduct(AddProductRequestDTO addProductRequestDTO);
    ProductResponseDTO productToProductResponseDTO(Product products);
}
