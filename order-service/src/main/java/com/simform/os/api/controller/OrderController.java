package com.simform.os.api.controller;

import com.simform.os.api.common.TransactionRequest;
import com.simform.os.api.common.TransactionResponse;
import com.simform.os.api.entity.Order;
import com.simform.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) throws Exception{
        return service.saveOrder(request);
    }

    @GetMapping("/getOrders")
    public List<Order> getAllOrders() throws Exception{
        return service.getAllOrders();
    }
}
