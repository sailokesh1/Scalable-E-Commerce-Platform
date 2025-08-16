package com.varunmatangi.product_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products")
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productStock;
    private String productCategory;
    private String productBrand;
    private String sku;
}
