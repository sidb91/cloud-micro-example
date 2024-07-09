package com.opolo.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opolo.paymentservice.entity.Payment;
import com.opolo.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository repository;

    public Payment savePayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    public String paymentProcessing(){
        //here it should be api call to 3rd party payment gateway - Paypal, Paytm
        return new Random().nextBoolean() ? "success":"failure";
    }

    public Payment findPaymentHistoryByOrderId(int orderId) {
        return repository.findByOrderId(orderId);
    }

}
