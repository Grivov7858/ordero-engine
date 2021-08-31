package com.qtech.orderoengine.service;

import com.qtech.orderoengine.model.entity.PlaceEntity;
import com.qtech.orderoengine.model.request.PlaceRequest;
import com.qtech.orderoengine.model.response.PlaceResponse;
import com.qtech.orderoengine.model.response.ProductResponse;
import com.qtech.orderoengine.repository.PlaceRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    public PlaceResponse getPlaceById(final Integer placeId) throws NotFoundException {
        PlaceEntity placeEntity = placeRepository.findById(placeId).orElseThrow(() -> new NotFoundException("Place not found for id " + placeId));

        List<ProductResponse> products = productService.remodelProductEntity(placeEntity.getProducts());
        return new PlaceResponse(placeEntity.getId(), placeEntity.getPlaceName(), products);
    }

    public void saveNewPlace(final PlaceRequest placeRequest) {
//        AppUser appUser = appUserService.getById(placeRequest.getOwner());
        PlaceEntity placeEntity = this.modelMapper.map(placeRequest, PlaceEntity.class);
//        placeEntity.setOwner(appUser);
        placeRepository.saveAndFlush(placeEntity);
    }
}
