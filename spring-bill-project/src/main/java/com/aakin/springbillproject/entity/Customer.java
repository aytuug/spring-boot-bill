package com.aakin.springbillproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "tc_no")
    private int tckn;

    //onetomany -> bill

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    private List<Bill> bills;





}
