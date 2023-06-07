package com.inventory.inventory.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddInventory {
    private String skuCode;
    private Integer quantity;
}
