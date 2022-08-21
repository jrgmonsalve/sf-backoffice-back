package com.softcaribbean.demo.repositories;

import com.softcaribbean.demo.models.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel,Long> {

}
