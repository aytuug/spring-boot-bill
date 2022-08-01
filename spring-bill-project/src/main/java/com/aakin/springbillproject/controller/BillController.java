package com.aakin.springbillproject.controller;

import com.aakin.springbillproject.dto.BillDto;
import com.aakin.springbillproject.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping("/{productId}/{customerId}")
    public ResponseEntity<BillDto> createBill(@PathVariable("productId") Integer productId,
                                              @PathVariable("customerId") Integer customerId,
                                              @RequestBody BillDto billDto){
        return ResponseEntity.ok(billService.createBill(billDto,productId,customerId));
    }





}
