package com.abhinav.cqrs.event.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder

public class Product {

    private String productName;
    private BigDecimal price;
    private Integer quantity;
}
