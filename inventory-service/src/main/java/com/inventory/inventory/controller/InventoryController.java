package com.inventory.inventory.controller;

import com.inventory.inventory.dto.AddInventory;
import com.inventory.inventory.service.InventoryCheck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryCheck inventoryCheck;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode){
        return inventoryCheck.isInStock(skuCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addInInventory(@RequestBody AddInventory addInventory){
        inventoryCheck.addInInventory(addInventory);
        log.info("Added Inventory");
    }
}
