package com.qtech.orderoengine.controller;

import com.qtech.orderoengine.model.request.MenuRequest;
import com.qtech.orderoengine.model.response.MenuResponse;
import com.qtech.orderoengine.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
    public ResponseEntity<MenuResponse> getMenuForPlaceById(@PathVariable Integer placeId) {
        MenuResponse menuResponse = menuService.getMenuById(placeId);

        return new ResponseEntity<>(menuResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Safe | Menu json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = MenuRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = MenuRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = MenuRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = MenuRequest.class)})
    @PostMapping(value = "safe/place")
    public void safeNewMenu(@RequestBody MenuRequest menuRequest) {
        menuService.safeNewMenu(menuRequest);
    }
}
