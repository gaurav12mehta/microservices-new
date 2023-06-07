package com.gaurav.orderservice.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    public List<OrderLineItemsDto> orderLineItemsList;
}
