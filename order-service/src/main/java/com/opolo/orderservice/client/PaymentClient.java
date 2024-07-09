package com.opolo.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import feign.Headers;

import com.opolo.orderservice.common.Payment;

@FeignClient(value = "PaymentClient", url = "http://localhost:9191/payment")
public interface PaymentClient {

    @PostMapping("/savePayment")
    @Headers("Content-Type: application/json")
    Payment saveOrder(@RequestBody Payment payment);
    
}
