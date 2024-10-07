package com.api.fakeapi.controller;

import com.api.fakeapi.model.request.CreateProductLocalRequest;
import com.api.fakeapi.model.response.CreateProductResponse;
import com.api.fakeapi.model.response.ProductResponse;
import com.api.fakeapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nexsys/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/")
    public Flux<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/")
    public Mono<CreateProductResponse> createProduct(@RequestBody CreateProductLocalRequest productRequest) {
        return productService.createProduct(productRequest);
    }
}
