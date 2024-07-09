package com.opolo.orderservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opolo.orderservice.common.TransactionRequest;
import com.opolo.orderservice.common.TransactionResponse;
import com.opolo.orderservice.entity.Order;
import com.opolo.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<String>("service is up!", null, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, null, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<Optional<Order>>> getOrder(@PathVariable Integer id){
        List<Optional<Order>> order = orderService.getOrder(id);
        return new ResponseEntity<List<Optional<Order>>>(order, null, HttpStatus.OK);
    }

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return orderService.saveOrder(request);
    }
}
