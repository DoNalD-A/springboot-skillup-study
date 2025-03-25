package com.skill.up.presentation;

import com.skill.up.application.ProductService;
import com.skill.up.dto.ProductDto;
import com.skill.up.entity.Product;
import com.skill.up.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping
    public List<Product> getProduct() {

        //service 호출
//        String result = new ProductService().getProduct();
        //service의 결과값을 클라이언트에게 전달

        List<Product> result = productService.getProduct();

        return result;
    }

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest) {

        productService.createProduct(ProductDto.from(productRequest));

    }

}
