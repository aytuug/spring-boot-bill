package com.aakin.springbillproject.controller;

import com.aakin.springbillproject.dto.CustomerDto;
import com.aakin.springbillproject.entity.Customer;
import com.aakin.springbillproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }




}
