package com.opolo.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

public class FallbackController {

    @RequestMapping("/orderFallback")
    public Mono<String> orderServiceFallback(){
        return Mono.just("Order service is taking too long to respond or is down, Please try again later");
    }

    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallback(){
        return Mono.just("Payment service is taking too long to respond or is down, Please try again later");
    }
    
}
