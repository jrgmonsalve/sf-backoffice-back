package com.softcaribbean.demo.services;

import com.softcaribbean.demo.models.CustomerModel;
import com.softcaribbean.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public ArrayList<CustomerModel> getAll(){
        return (ArrayList<CustomerModel>) customerRepository.findAll();
    }

    public CustomerModel save(CustomerModel customerModel){
        return customerRepository.save(customerModel);
    }

    public Optional<CustomerModel> getById(Long id){
        return customerRepository.findById(id);
    }

    public boolean deleteById(Long id){
        try {
            customerRepository.deleteById(id);
            return true;
        }catch (Exception ex) {
            return false;
        }
    }
}
