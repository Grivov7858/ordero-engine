package com.qtech.orderoengine.service;

import com.qtech.orderoengine.model.entity.PlaceEntity;
import com.qtech.orderoengine.model.entity.ProductEntity;
import com.qtech.orderoengine.model.request.ProductRequest;
import com.qtech.orderoengine.model.response.ProductResponse;
import com.qtech.orderoengine.repository.PlaceRepository;
import com.qtech.orderoengine.repository.ProductRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    public void saveNewProduct(final ProductRequest productRequest) throws NotFoundException {
        PlaceEntity placeEntity = placeRepository.findById(productRequest.getPlaceId())
                .orElseThrow(() -> new NotFoundException("Place not found for id " + productRequest.getPlaceId()));

        ProductEntity productEntity = modelMapper.map(productRequest, ProductEntity.class);

        productEntity.setPlace(placeEntity);

        productRepository.saveAndFlush(productEntity);
    }

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
