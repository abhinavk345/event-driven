package com.abhinav.cqrs.event.command.api.controller;

import com.abhinav.cqrs.event.command.api.controller.commands.CreateProductCommand;
import com.abhinav.cqrs.event.model.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductCommandController {

    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/add")
    public String saveProduct(@RequestBody Product product){

        CreateProductCommand createProductCommand= CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

        String response =commandGateway.sendAndWait(createProductCommand);
        return response;
    }
}
