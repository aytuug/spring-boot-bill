package com.aakin.springbillproject.service;

import com.aakin.springbillproject.dto.BillDto;
import com.aakin.springbillproject.dto.converter.BillDtoConverter;
import com.aakin.springbillproject.dto.converter.CustomerDtoConverter;
import com.aakin.springbillproject.dto.converter.ProductDtoConverter;
import com.aakin.springbillproject.entity.Bill;
import com.aakin.springbillproject.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;
    private final BillDtoConverter billDtoConverter;
    private final ProductDtoConverter productDtoConverter;

    public BillDto createBill(BillDto billDto){

        Bill bill = new Bill();

        bill.setProducts(billDto
                .getProducts()
                .stream()
                .map(productDtoConverter::convertProduct)
                .collect(Collectors.toList()));

        bill.setBillId(bill.getBillId());
        bill.setCustomer(bill.getCustomer());
        bill.setProductPrice(bill.getProductPrice());
        bill.setCustomerName(bill.getCustomerName());

        billRepository.save(bill);
        return billDtoConverter.convertBillDto(bill);

    }



}
