package com.skill.up.application;

import com.skill.up.Infrastructure.ProductRepository;
import com.skill.up.dto.ProductDto;
import com.skill.up.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProduct() {

        // db에 접근해서, 필요한 정보를 가져와서
        List<Product> products = productRepository.findAll();
        // 우리의 비지니스 로직에 맞게 가공한 다음
        // 컨트롤러에게 전달

        return products;
    }

    @Transactional
    public void createProduct(ProductDto productDto) {
        // dto -> entity
//        Product product = Product.builder()
//                .name(productDto.getName())
//                .price(productDto.getPrice())
//                .build();
//
//
//        productRepository.save(product);

        productRepository.save(productDto.toEntity());
    }
}
