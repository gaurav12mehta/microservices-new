package com.gaurav.orderservice.controller;

import com.gaurav.orderservice.dto.OrderRequest;
import com.gaurav.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void order(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);
        log.info("Order is saved");
    }
}
