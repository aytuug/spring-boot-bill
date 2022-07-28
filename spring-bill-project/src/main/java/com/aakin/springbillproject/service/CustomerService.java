package com.aakin.springbillproject.service;

import com.aakin.springbillproject.dto.BillDto;
import com.aakin.springbillproject.dto.CustomerDto;
import com.aakin.springbillproject.dto.converter.BillDtoConverter;
import com.aakin.springbillproject.dto.converter.CustomerDtoConverter;
import com.aakin.springbillproject.entity.Bill;
import com.aakin.springbillproject.entity.Customer;
import com.aakin.springbillproject.repository.BillRepository;
import com.aakin.springbillproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    private final BillDtoConverter billDtoConverter;

    public CustomerDto createCustomer(CustomerDto customerDto){

        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerEmail(customerDto.getCustomerEmail());

        customer.setBills(customerDto.getBills()
                .stream()
                .map(billDtoConverter::convertBill)
                .collect(Collectors.toList()));

        customer.setTckn(customerDto.getTckn());

        customerRepository.save(customer);
        return customerDtoConverter.convertCustomerDto(customer);
    }
}
