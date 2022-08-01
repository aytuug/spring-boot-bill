package com.aakin.springbillproject.service;

import com.aakin.springbillproject.dto.BillDto;
import com.aakin.springbillproject.dto.ProductDto;
import com.aakin.springbillproject.dto.converter.BillDtoConverter;
import com.aakin.springbillproject.dto.converter.CustomerDtoConverter;
import com.aakin.springbillproject.dto.converter.ProductDtoConverter;
import com.aakin.springbillproject.entity.Bill;
import com.aakin.springbillproject.entity.Customer;
import com.aakin.springbillproject.entity.Product;
import com.aakin.springbillproject.repository.BillRepository;
import com.aakin.springbillproject.repository.CustomerRepository;
import com.aakin.springbillproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillDtoConverter billDtoConverter;
    private final ProductDtoConverter productDtoConverter;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final BillRepository billRepository;


    public BillDto createBill(Integer productId, Integer customerId){

        Bill bill = new Bill();

        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
            bill.setProductName(product.get().getProductName());
            bill.setProductPrice(product.get().getProductPrice());
        }

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()){
            bill.setCustomerName(customer.get().getCustomerName());
            bill.setCustomer(customer.get());
        }

        //bill.setBillId(billDto.getBillId());
        /*
        bill.setProducts(billDto
                .getProducts()
                .stream()
                .map(productDtoConverter::convertProduct)
                .collect(Collectors.toList()));
*/
        billRepository.save(bill);

        return billDtoConverter.convertBillDto(bill);

    }


    public List<BillDto> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        List<BillDto> billDtoList = new ArrayList<>();

        for (Bill bill : bills){
            billDtoList.add(billDtoConverter.convertBillDto(bill));
        }
        return billDtoList;
    }


    public BillDto getBillById(Integer id) {

        Optional<Bill> billOptional = billRepository.findById(id);
        return billOptional.map(billDtoConverter::convertBillDto).orElse(null);

    }


    public void deleteBill(Integer id) {
        billRepository.deleteById(id);
    }


}
