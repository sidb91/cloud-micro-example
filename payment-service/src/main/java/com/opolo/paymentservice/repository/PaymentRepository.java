package com.opolo.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opolo.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

    Payment findByOrderId(int orderId);
    
}
