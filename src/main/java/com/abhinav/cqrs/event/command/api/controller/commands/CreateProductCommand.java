package com.abhinav.cqrs.event.command.api.controller.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Builder
@Data
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
}
