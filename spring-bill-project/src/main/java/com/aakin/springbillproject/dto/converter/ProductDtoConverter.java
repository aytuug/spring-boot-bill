package com.aakin.springbillproject.dto.converter;


import com.aakin.springbillproject.dto.ProductDto;
import com.aakin.springbillproject.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDtoConverter {

    //private final ModelMapper modelMapper;

    public ProductDto convertProductDto(Product product){

        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setProductQuantity(product.getProductQuantity());
        productDto.setProductPrice(product.getProductPrice());
        //productDto.setBills(product.getBill());
        return productDto;

    }

    public Product convertProduct(ProductDto productDto){

        Product product = new Product();
        //product.setProductId(product.getProductId()); id setlemiyoruz.
        product.setProductName(productDto.getProductName());
        product.setProductQuantity(productDto.getProductQuantity());
        product.setProductPrice(productDto.getProductPrice());
        product.setBill(product.getBill());

        return product;
    }

}
