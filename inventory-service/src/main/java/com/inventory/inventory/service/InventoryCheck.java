package com.inventory.inventory.service;

import com.inventory.inventory.dto.AddInventory;
import com.inventory.inventory.dto.InventoryResponse;
import com.inventory.inventory.model.Inventory;
import com.inventory.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryCheck {

    private final InventoryRepository inventoryRepository;
//    private final Inventory inventory;
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
//        return inventoryRepository.findAll().isEmpty();
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity()>0)
                        .build())
                        .toList();
//        return inventoryRepository.findBySkuCode(skuCode).isPresent();
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
