package com.api.fakeapi.service;

import com.api.fakeapi.model.request.CategoryRequest;
import com.api.fakeapi.model.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final WebClient.Builder webClientBuilder;

    @Value("${base.url.api}")
    private String baseApiUrl;


    public Flux<CategoryResponse> getAllCategories() {
        String apiUrl = baseApiUrl + "/api/v1/categories";

        return this.webClientBuilder.build()
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToFlux(CategoryRequest.class)
                .map(category -> {
                    CategoryResponse response = new CategoryResponse();
                    response.setCid(category.getId());
                    response.setTitle(category.getName());
                    return response;
                });
    }
}
