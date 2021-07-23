package com.qtech.orderoengine.service;

import com.qtech.orderoengine.model.MenuEntity;
import com.qtech.orderoengine.model.ProductEntity;
import com.qtech.orderoengine.model.request.MenuRequest;
import com.qtech.orderoengine.model.request.ProductRequest;
import com.qtech.orderoengine.model.response.MenuResponse;
import com.qtech.orderoengine.model.response.ProductResponse;
import com.qtech.orderoengine.repository.MenuRepository;
import com.qtech.orderoengine.repository.ProductRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    public MenuResponse getMenuById(final Integer placeId) throws NotFoundException {
        MenuEntity menuEntity = menuRepository.findById(placeId).orElseThrow(() -> new NotFoundException("Menu not found for id " + placeId));

        List<ProductResponse> products = productService.remodelProductEntity(menuEntity.getProducts());
        return new MenuResponse(menuEntity.getId(), menuEntity.getPlaceName(), products );
    }

    public void saveNewPlace(final MenuRequest menuRequest) {
        MenuEntity menuEntity = this.modelMapper.map(menuRequest, MenuEntity.class);

        menuRepository.saveAndFlush(menuEntity);
    }

    public void saveNewProduct(final ProductRequest productRequest) throws NotFoundException {
        MenuEntity menuEntity = menuRepository.findById(productRequest.getMenuId())
                .orElseThrow(() -> new NotFoundException("Menu not found for id " + productRequest.getMenuId()));

        ProductEntity productEntity = modelMapper.map(productRequest, ProductEntity.class);

        productEntity.setMenu(menuEntity);

        productRepository.saveAndFlush(productEntity);
    }
}
