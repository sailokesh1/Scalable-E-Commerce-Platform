package com.varunmatangi.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private String productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productStock;
    private String productCategory;
    private String productBrand;
    private String sku;
}
