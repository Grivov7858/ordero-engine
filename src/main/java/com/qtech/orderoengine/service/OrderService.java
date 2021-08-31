package com.qtech.orderoengine.service;

import com.qtech.orderoengine.model.entity.MassEntity;
import com.qtech.orderoengine.model.entity.PlaceEntity;
import com.qtech.orderoengine.model.entity.ProductEntity;
import com.qtech.orderoengine.model.request.OrderRequest;
import com.qtech.orderoengine.model.response.MassResponse;
import com.qtech.orderoengine.model.response.OrderResponse;
import com.qtech.orderoengine.model.response.ProductResponse;
import com.qtech.orderoengine.repository.MassRepository;
import com.qtech.orderoengine.repository.PlaceRepository;
import com.qtech.orderoengine.repository.ProductRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private MassRepository massRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void saveNewOrder(final OrderRequest orderRequest) throws NotFoundException {
        MassEntity massEntity = this.modelMapper.map(orderRequest, MassEntity.class);

        PlaceEntity placeEntity = placeRepository.findById(orderRequest.getPlaceId())
                .orElseThrow(() -> new NotFoundException("Place not found for id " + orderRequest.getPlaceId()));
        massEntity.setPlace(placeEntity);

        Optional<MassEntity> optionalMassEntity = massRepository.findById(orderRequest.getMassId());

        addPreviousProductsIfExist(massEntity, optionalMassEntity);

        massRepository.saveAndFlush(massEntity);
    }


    public OrderResponse getAllMasses(final Integer placeId) throws NotFoundException {
        PlaceEntity placeEntity = placeRepository.findById(placeId)
                .orElseThrow(() -> new NotFoundException("Place not found for id " + placeId));

        List<MassEntity> massesEntity = placeEntity.getMasses();
        List<MassResponse> masses = new ArrayList<>();


        for (MassEntity massEntity : massesEntity) {
            List<Integer> productIds = massEntity.getProductIds();
            List<ProductResponse> products = getAllProductsByIds(productIds);

            masses.add(new MassResponse(massEntity.getId(), products));
        }


        return new OrderResponse(placeId, masses);
    }

    private List<ProductResponse> getAllProductsByIds(List<Integer> productIds) throws NotFoundException {
        List<ProductResponse> products = new ArrayList<>();

        for (Integer productId : productIds) {
            ProductEntity productEntity = productRepository.findById(productId)
                    .orElseThrow(() -> new NotFoundException("Product not found for id " + productId));

            products.add(new ProductResponse(productId,
                    productEntity.getName(),
                    productEntity.getDescription(),
                    productEntity.getPrice(),
                    productEntity.getCategory()));
        }
        return products;
    }

    private void addPreviousProductsIfExist(MassEntity massEntity, Optional<MassEntity> optionalMassEntity) {
        if (optionalMassEntity.isPresent()) {
            MassEntity alreadyCreatedMass = optionalMassEntity.get();
            List<Integer> productIds = massEntity.getProductIds();

            productIds.addAll(alreadyCreatedMass.getProductIds());

            massEntity.setProductIds(productIds);
        }
    }
}
