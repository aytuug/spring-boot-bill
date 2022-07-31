package com.aakin.springbillproject.service;

import com.aakin.springbillproject.dto.ProductDto;
import com.aakin.springbillproject.dto.converter.ProductDtoConverter;
import com.aakin.springbillproject.entity.Product;
import com.aakin.springbillproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        productRepository.save(product);
        return productDtoConverter.convertProductDto(product);
    }


    public List<ProductDto> getAllProducts() {

        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productList){
            productDtoList.add(productDtoConverter.convertProductDto(product));
        }

        return productDtoList;

    }

    public ProductDto getProductById(Integer id) {

        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(productDtoConverter::convertProductDto).orElse(null);

    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public ProductDto updateProduct(Integer id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);

        productOptional.ifPresent(product -> {
            product.setProductName(productDto.getProductName());
            product.setProductQuantity(productDto.getProductQuantity());
            product.setProductPrice(productDto.getProductPrice());

            productRepository.save(product);
        });

        return productOptional.map(productDtoConverter::convertProductDto).orElse(null);

    }
}
