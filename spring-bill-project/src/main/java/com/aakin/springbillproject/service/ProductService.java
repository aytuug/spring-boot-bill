package com.aakin.springbillproject.service;

import com.aakin.springbillproject.dto.ProductDto;
import com.aakin.springbillproject.dto.converter.ProductDtoConverter;
import com.aakin.springbillproject.entity.Product;
import com.aakin.springbillproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;

    public ProductDto createProduct(ProductDto productDto){

        Product product = new Product();
        
        product.setProductQuantity(productDto.getProductQuantity());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductName(productDto.getProductName());
        productDtoConverter.convertProductDto(product);
        productRepository.save(product);
        return productDto;

    }


}
