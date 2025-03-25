package com.skill.up.dto;

import com.skill.up.entity.Product;
import com.skill.up.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private int price;

    public static ProductDto from(ProductRequest productRequest) {
        return ProductDto.builder()
                .price(productRequest.getPrice())
                .name(productRequest.getName())
                .build();
    }

    public Product toEntity() {

        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }

}
