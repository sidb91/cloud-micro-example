package com.opolo.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opolo.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

    
}
