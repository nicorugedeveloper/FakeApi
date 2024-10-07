package com.api.fakeapi.service;

import com.api.fakeapi.model.request.ProductRequest;
import com.api.fakeapi.model.response.CategoryResponse;
import com.api.fakeapi.model.response.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.escuelajs.co/api/v1").build();
    }

    public Flux<ProductResponse> getAllProducts() {
        return this.webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(ProductResponse.class)
                .map(product -> {
                    ProductResponse response = new ProductResponse();
                    response.setPid(product.getPid());
                    response.setName(product.getName());
                    response.setPriceFinal(product.getPriceFinal());
                    response.setDescription(product.getDescription());

                    if (product.getCategory() != null) {
                        CategoryResponse categoryResponse = new CategoryResponse();
                        categoryResponse.setCid(product.getCategory().getCid());
                        categoryResponse.setTitle(product.getCategory().getTitle());
                        response.setCategory(categoryResponse);
                    }

                    response.setImages(product.getImages());
                    return response;
                });
    }
    public Flux<CategoryResponse> getAllCategories() {
        return this.webClient.get()
                .uri("/categories")
                .retrieve()
                .bodyToFlux(CategoryResponse.class)
                .map(category -> {
                    CategoryResponse response = new CategoryResponse();
                    response.setCid(category.getCid());
                    response.setTitle(category.getTitle());
                    return response;
                });
    }
    public Mono<Integer> createProduct(ProductRequest productRequest) {
        return this.webClient.post()
                .uri("/products")
                .bodyValue(productRequest)
                .retrieve()
                .bodyToMono(Integer.class);
    }
}
