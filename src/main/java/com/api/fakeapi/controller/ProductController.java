package com.api.fakeapi.controller;

import com.api.fakeapi.model.request.ProductRequest;
import com.api.fakeapi.model.response.CategoryResponse;
import com.api.fakeapi.model.response.ProductResponse;
import com.api.fakeapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/categories/")
    public Flux<CategoryResponse> getAllCategories() {
        return productService.getAllCategories();
    }

    @PostMapping("/products/")
    public Mono<Integer> createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }
}
