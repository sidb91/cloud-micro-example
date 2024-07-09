package com.opolo.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opolo.paymentservice.entity.Payment;
import com.opolo.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/health")
    public String healthCheck(){
        return "service is up!";
    }

    @PostMapping("/savePayment")
    public Payment savePayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }
    
}
