package com.aakin.springbillproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    private String customerName;
    private String productName;
    private double productPrice;

    private List<ProductDto> products;


}
