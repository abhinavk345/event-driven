package com.abhinav.cqrs.event.command.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity

public class Product {
    @Id
    private String productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
}
