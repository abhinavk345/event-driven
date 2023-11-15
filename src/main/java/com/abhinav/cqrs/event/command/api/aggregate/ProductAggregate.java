package com.abhinav.cqrs.event.command.api.aggregate;

import com.abhinav.cqrs.event.command.api.controller.commands.CreateProductCommand;
import com.abhinav.cqrs.event.command.api.events.ProductCreatedEvents;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){

        ProductCreatedEvents productCreatedEvent= new ProductCreatedEvents();
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);

    }

    @EventSourcingHandler
    public  void on(ProductCreatedEvents productCreatedEvents){

        this.price=productCreatedEvents.getPrice();
        this.productName=productCreatedEvents.getProductName();
        this.quantity=productCreatedEvents.getQuantity();
        this.productId=productCreatedEvents.getProductId();

    }
    public ProductAggregate(){

    }
}
