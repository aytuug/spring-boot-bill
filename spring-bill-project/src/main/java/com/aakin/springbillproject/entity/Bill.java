package com.aakin.springbillproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "bill")
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int billId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;


    //onetomany -> product
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Product> products;

    //manytoone -> customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;




}
