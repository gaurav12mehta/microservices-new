package com.inventory.inventory.service;

import com.inventory.inventory.dto.AddInventory;
import com.inventory.inventory.model.Inventory;
import com.inventory.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryCheck {

    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
//        return inventoryRepository.findAll().isEmpty();
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    public void addInInventory(AddInventory addInventory){
        Inventory inventory = Inventory.builder()
                .skuCode(addInventory.getSkuCode())
                .quantity(addInventory.getQuantity())
                .build();

        log.info("skuCode {}",addInventory.getSkuCode());

        inventoryRepository.save(inventory);

    }

}
