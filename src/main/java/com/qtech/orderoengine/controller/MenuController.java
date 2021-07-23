package com.qtech.orderoengine.controller;

import com.qtech.orderoengine.model.request.MenuRequest;
import com.qtech.orderoengine.model.request.ProductRequest;
import com.qtech.orderoengine.model.response.MenuResponse;
import com.qtech.orderoengine.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@Api(value = "Menu Controller | Allows saving new menu and receiving existing menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "Receive | Menu json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = MenuResponse.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = MenuResponse.class),
            @ApiResponse(code = 404, message = "Not found - The place does not exist", response = MenuResponse.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = MenuResponse.class)})
    @GetMapping(value = "placeId/{placeId}")
    public MenuResponse getMenuForPlaceById(@PathVariable Integer placeId) throws NotFoundException {

        return menuService.getMenuById(placeId);
    }

    @ApiOperation(value = "Save | Menu json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = MenuRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = MenuRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = MenuRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = MenuRequest.class)})
    @PostMapping(value = "save/place")
    public void saveNewPlace(@RequestBody MenuRequest menuRequest) {
        menuService.saveNewPlace(menuRequest);
    }

    @ApiOperation(value = "Save | Product json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = MenuRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = MenuRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = MenuRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = MenuRequest.class)})
    @PostMapping(value = "save/product")
    public void saveNewProduct(@RequestBody ProductRequest productRequest) throws NotFoundException {
        menuService.saveNewProduct(productRequest);
    }
}
