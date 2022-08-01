package com.aakin.springbillproject.dto.converter;

import com.aakin.springbillproject.dto.BillDto;
import com.aakin.springbillproject.entity.Bill;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BillDtoConverter {

    private final ProductDtoConverter productDtoConverter;

    public BillDto convertBillDto(Bill bill){

        BillDto billDto = new BillDto();
        billDto.setProductName(bill.getProductName());
        billDto.setProductPrice(bill.getProductPrice());
        billDto.setCustomerName(bill.getCustomerName());
//        billDto.setProducts(bill.getProducts().stream().map(productDtoConverter::convertProductDto).collect(Collectors.toList()));
        return billDto;

    }

    public Bill convertBill(BillDto billDto){

       Bill bill = new Bill();
       bill.setProductName(billDto.getProductName());
       bill.setProductPrice(billDto.getProductPrice());
       bill.setCustomerName(billDto.getCustomerName());
//       bill.setProducts(billDto.getProducts().stream().map(productDtoConverter::convertProduct).collect(Collectors.toList()));
       return bill;

    }


}
