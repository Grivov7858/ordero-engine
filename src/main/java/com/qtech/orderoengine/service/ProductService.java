package com.qtech.orderoengine.service;

import com.qtech.orderoengine.model.ProductEntity;
import com.qtech.orderoengine.model.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<ProductResponse> remodelProductEntity(final List<ProductEntity> productEntities) {
        List<ProductResponse> products = new ArrayList<>();

        for (ProductEntity productEntity : productEntities) {
            products.add(new ProductResponse(productEntity.getId(),
                    productEntity.getName(),
                    productEntity.getDescription(),
                    productEntity.getPrice(),
                    productEntity.getCategory()));
        }

        return products;
    }
}
