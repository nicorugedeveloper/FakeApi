package com.api.fakeapi.controller;

import com.api.fakeapi.model.response.CategoryResponse;
import com.api.fakeapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/nexsys/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/")
    public Flux<CategoryResponse> getAllCategories() {

        return categoryService.getAllCategories();
    }
}
