package com.aakin.springbillproject.controller;

import com.aakin.springbillproject.dto.BillDto;
import com.aakin.springbillproject.dto.ProductDto;
import com.aakin.springbillproject.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping("/{productId}/{customerId}")
    public ResponseEntity<BillDto> createBill(@PathVariable("productId") Integer productId,
                                              @PathVariable("customerId") Integer customerId
                                              ){
        return ResponseEntity.ok(billService.createBill(productId,customerId));
    }

    @GetMapping
    public ResponseEntity<List<BillDto>> getAllBills(){
        return ResponseEntity.ok(billService.getAllBills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDto> getBillById(@PathVariable Integer id){
        return ResponseEntity.ok(billService.getBillById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Integer id){
        billService.deleteBill(id);
        return ResponseEntity.ok().build();
    }

}
