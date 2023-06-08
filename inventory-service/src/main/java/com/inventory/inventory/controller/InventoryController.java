package com.inventory.inventory.controller;

import com.inventory.inventory.dto.AddInventory;
import com.inventory.inventory.dto.InventoryResponse;
import com.inventory.inventory.service.InventoryCheck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryCheck inventoryCheck;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        log.info("In Inventory Service skuCode = {}",skuCode);
        List<InventoryResponse> responses = inventoryCheck.isInStock(skuCode);
        log.info("Response from Inventory Service {}" , responses);
        return responses;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addInInventory(@RequestBody AddInventory addInventory){
        inventoryCheck.addInInventory(addInventory);
        log.info("Added Inventory");
    }
}
