package com.aakin.springbillproject.dto.converter;

import com.aakin.springbillproject.dto.BillDto;
import com.aakin.springbillproject.dto.CustomerDto;
import com.aakin.springbillproject.dto.ProductDto;
import com.aakin.springbillproject.entity.Bill;
import com.aakin.springbillproject.entity.Customer;
import com.aakin.springbillproject.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerDtoConverter {

    //private final ModelMapper modelMapper;
    private final BillDtoConverter billDtoConverter;

    public CustomerDto convertCustomerDto(Customer customer){
        /*
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;

         */

        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerEmail(customer.getCustomerEmail());
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setTckn(customer.getTckn());
        customerDto.setBills(customer.getBills().stream().map(billDtoConverter::convertBillDto).collect(Collectors.toList()));
        return customerDto;

    }

    public Customer convertCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerName(customer.getCustomerName());
        customer.setCustomerEmail(customer.getCustomerEmail());
        customer.setTckn(customer.getTckn());
        customer.setBills(customer.getBills());
        return customer;
        /*
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customer;

         */
    }




}
