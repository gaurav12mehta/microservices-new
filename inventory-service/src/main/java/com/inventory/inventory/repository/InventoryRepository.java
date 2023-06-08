package com.inventory.inventory.repository;

import com.inventory.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    @Query(value = "SELECT * FROM inventory where skuCode=skuCode;")
//    Optional<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
