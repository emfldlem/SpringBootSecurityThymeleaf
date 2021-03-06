package com.template.sbssth.Dao;

import com.template.sbssth.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query(nativeQuery = true, value="select * from customer where name = :Name")
    Customer findByName(@Param("Name") String Name);

    //List<String> authFindbyName(String Name);


}
