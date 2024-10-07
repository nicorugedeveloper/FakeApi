package com.api.fakeapi.service;

import com.api.fakeapi.model.request.CreateProductApiRequest;
import com.api.fakeapi.model.request.CreateProductLocalRequest;
import com.api.fakeapi.model.request.ProductRequest;
import com.api.fakeapi.model.response.CreateProductResponse;
import com.api.fakeapi.model.response.ProductApiResponse;
import com.api.fakeapi.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient.Builder webClientBuilder;

    @Value("${base.url.api}")
    private String baseApiUrl;

    public Flux<ProductResponse> getAllProducts() {
        String apiUrl = baseApiUrl + "/api/v1/products";

        return this.webClientBuilder.build()
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToFlux(ProductRequest.class)
                .map(product -> {
                    ProductResponse productResponse = new ProductResponse();

                    productResponse.setPid(product.getId());
                    productResponse.setName(product.getTitle());
                    productResponse.setPriceFinal(product.getPrice());
                    productResponse.setDescription(product.getDescription());

                    return productResponse;
                });
    }

    public Mono<CreateProductResponse> createProduct(CreateProductLocalRequest productRequest) {
        String apiUrl = baseApiUrl + "/api/v1/products/";

        CreateProductApiRequest createProductApiRequest = new CreateProductApiRequest();

        createProductApiRequest.setTitle(productRequest.getName());
        createProductApiRequest.setPrice(productRequest.getPriceFinal());
        createProductApiRequest.setDescription(productRequest.getDescription());
        createProductApiRequest.setCategoryId(productRequest.getCategoryId());
        createProductApiRequest.setImages(Collections.singletonList(productRequest.getImageUrl()));

        return this.webClientBuilder.build()
                .post()
                .uri(apiUrl)
                .bodyValue(createProductApiRequest)
                .retrieve()
                .bodyToMono(ProductApiResponse.class)
                .map(productApiResponse -> {
                    CreateProductResponse createProductResponse = new CreateProductResponse();
                    createProductResponse.setPid(productApiResponse.getId());
                    return createProductResponse;
                });
    }
}
