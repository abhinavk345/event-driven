package com.abhinav.cqrs.event.command.api.events;

import com.abhinav.cqrs.event.command.api.entity.Product;
import com.abhinav.cqrs.event.command.api.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private ProductRepository  productRepository;

    @Autowired
    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvents events){
        Product product= new Product();
        BeanUtils.copyProperties(events,product);
        productRepository.save(product);

    }
}
