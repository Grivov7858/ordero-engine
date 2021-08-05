package com.qtech.orderoengine.controller;

import com.qtech.orderoengine.model.request.PlaceRequest;
import com.qtech.orderoengine.model.response.PlaceResponse;
import com.qtech.orderoengine.service.PlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
@Api(value = "Place Controller | Allows saving new place and receiving existing place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @CrossOrigin
    @ApiOperation(value = "Receive | Place json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PlaceResponse.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = PlaceResponse.class),
            @ApiResponse(code = 404, message = "Not found - The place does not exist", response = PlaceResponse.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = PlaceResponse.class)})
    @GetMapping(value = "/placeId/{placeId}")
    public PlaceResponse getPlaceById(@PathVariable Integer placeId) throws NotFoundException {

        return placeService.getPlaceById(placeId);
    }

    @ApiOperation(value = "Save | Place json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PlaceRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = PlaceRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = PlaceRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = PlaceRequest.class)})
    @PostMapping(value = "/save/place")
    public void saveNewPlace(@RequestBody PlaceRequest placeRequest) {
        placeService.saveNewPlace(placeRequest);
    }
}
