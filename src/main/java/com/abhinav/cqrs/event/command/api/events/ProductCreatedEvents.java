package com.abhinav.cqrs.event.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvents {

    private String productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
}
