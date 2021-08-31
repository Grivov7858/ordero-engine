package com.qtech.orderoengine.controller;

import com.qtech.orderoengine.model.request.AppUserRequest;
import com.qtech.orderoengine.model.request.PlaceRequest;
import com.qtech.orderoengine.service.AppUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@Api(value = "Registration Controller | Allows registering new Places")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    /*
    @ApiOperation(value = "Get all  | Get All Owners")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PlaceRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = PlaceRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = PlaceRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = PlaceRequest.class)})
    @GetMapping("/owners")
    public ResponseEntity<List<AppUser>> getAll () {
        return ResponseEntity.ok().body(appUserService.());
    }
     */

    @ApiOperation(value = "POST | Save a AppUser")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PlaceRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = PlaceRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = PlaceRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = PlaceRequest.class)})
    @PostMapping("/register")
    public ResponseEntity<AppUserRequest> post(@RequestBody AppUserRequest appUserRequest) {
        return new ResponseEntity<AppUserRequest>(appUserService.validateAndRegister(appUserRequest), HttpStatus.CREATED);
    }



    /*
    @ApiOperation(value = "POST | Save a Role")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PlaceRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = PlaceRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = PlaceRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = PlaceRequest.class)})
    @PostMapping("/role/save")
    public ResponseEntity<AppUserRole> post (@RequestBody AppUserRole appUserRole) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.(appUserRole));
    }


    @ApiOperation(value = "POST | Save a Role")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PlaceRequest.class),
            @ApiResponse(code = 400, message = "Bad Request - You might forgot a parameter", response = PlaceRequest.class),
            @ApiResponse(code = 404, message = "Not found", response = PlaceRequest.class),
            @ApiResponse(code = 500, message = "Error - A wide range of causes, check logs", response = PlaceRequest.class)})
    @PostMapping("/role/assign")
    public ResponseEntity<?> assignRole (@RequestBody RoleToOwnerRequest form) {
        appUserService.addRoleToOwner(form.getEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    */

}
