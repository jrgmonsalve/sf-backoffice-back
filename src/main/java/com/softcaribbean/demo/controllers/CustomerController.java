package com.softcaribbean.demo.controllers;

import com.softcaribbean.demo.models.CustomerModel;
import com.softcaribbean.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ArrayList<CustomerModel> getAll() {
        return customerService.getAll();
    }

    @PostMapping
    public CustomerModel save(@RequestBody CustomerModel customerModel){
        return customerService.save(customerModel);
    }

    @GetMapping(path="/{id}")
    public Optional<CustomerModel> getById(@PathVariable("id") Long id) {
        return customerService.getById(id);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        if (customerService.deleteById(id)){
            return "Customer with id:" + id+" was deleted.";
        }else{
            return "We can't delete customer with id:" + id;
        }
    }

}
