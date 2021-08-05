package com.qtech.orderoengine.controller;

import com.qtech.orderoengine.model.request.PlaceRequest;
import com.qtech.orderoengine.model.request.ProductRequest;
import com.qtech.orderoengine.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Api(value = "Product Controller | Allows saving new product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Save | Product json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PlaceRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = PlaceRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = PlaceRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = PlaceRequest.class)})
    @PostMapping(value = "/save")
    public void saveNewProduct(@RequestBody ProductRequest productRequest) throws NotFoundException {
        productService.saveNewProduct(productRequest);
    }
}
