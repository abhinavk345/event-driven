package com.abhinav.cqrs.event.command.api.repository;

import com.abhinav.cqrs.event.command.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,String> {
}
