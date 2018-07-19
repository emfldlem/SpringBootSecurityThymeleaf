package com.template.sbssth.Dao;

import com.template.sbssth.Model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String Name);
}
