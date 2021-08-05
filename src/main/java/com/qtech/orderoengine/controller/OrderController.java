package com.qtech.orderoengine.controller;

import com.qtech.orderoengine.model.request.OrderRequest;
import com.qtech.orderoengine.model.response.OrderResponse;
import com.qtech.orderoengine.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api(value = "Order Controller | Allows saving new order for current place")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @ApiOperation(value = "Order | Mass json")
    @PostMapping(value = "/save")
    public OrderResponse saveNewOrder(@RequestBody OrderRequest orderRequest) throws NotFoundException {
        orderService.saveNewOrder(orderRequest);

        return orderService.getAllMasses(orderRequest.getPlaceId());
    }


}
