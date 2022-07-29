package com.aakin.springbillproject.dto;


import com.aakin.springbillproject.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    private String productName;
    private Integer productQuantity;
    private Double productPrice;


}
