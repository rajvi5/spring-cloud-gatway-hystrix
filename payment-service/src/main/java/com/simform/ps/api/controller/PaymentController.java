package com.simform.ps.api.controller;

import com.simform.ps.api.entity.Payment;
import com.simform.ps.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) throws Exception {
        return service.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) throws Exception{
              return service.findPaymentHistoryByOrderId(orderId);
    }

    @GetMapping("/getPayments")
    public List<Payment> findAllPayments() throws Exception{
        return service.findAllPayments();
    }
}
