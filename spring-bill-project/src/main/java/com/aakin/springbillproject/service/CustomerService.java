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
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerDto createCustomer(CustomerDto customerDto){

        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setTckn(customerDto.getTckn());

        customerRepository.save(customer);
        return customerDtoConverter.convertCustomerDto(customer);
    }

    public List<CustomerDto> getAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList   = new ArrayList<>();

        for (Customer customer : customerList){
            customerDtoList.add(customerDtoConverter.convertCustomerDto(customer));
        }

        return customerDtoList;

    }

    public CustomerDto getCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.map(customerDtoConverter::convertCustomerDto).orElse(null);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto updateCustomer(Integer id, CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        customerOptional.ifPresent(customer -> {
            customer.setCustomerName(customerDto.getCustomerName());
            customer.setCustomerEmail(customerDto.getCustomerEmail());
            customer.setTckn(customerDto.getTckn());

            customerRepository.save(customer);
        });
        return customerOptional.map(customerDtoConverter::convertCustomerDto).orElse(null);
    }
}
