package com.aakin.springbillproject.repository;

import com.aakin.springbillproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //customer query
    //model mapper, object mapper ->sni object mapper.
}
