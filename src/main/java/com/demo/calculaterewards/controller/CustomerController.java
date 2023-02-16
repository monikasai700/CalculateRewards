package com.demo.calculaterewards.controller;

import com.demo.calculaterewards.CustomerDTO;
import com.demo.calculaterewards.model.Customer;
import com.demo.calculaterewards.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Gets the list of customers
    @GetMapping(value = {"/","customers"})
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    // Gets the details of the customer with given customer id
    @GetMapping("/customers/{id}")
    public Optional<Customer> getUserById(@PathVariable("id") Long id){
        return customerService.getCustomerById(id);
    }

    // Gets the reward details of the customer
    @GetMapping("/customers/rewards/{id}")
    public CustomerDTO getCustomerRewards(@PathVariable("id") Long id){
        return customerService.getCustomerRewards(id);
    }

    // Creates a customer from the request body details
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        customerService.calculateRewardsById(customer.getId());
        return customer;
    }

    // Updates the customer details
    @PutMapping("/customers/{id}")
    public Optional<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        customerService.updateCustomer(id,customer);
        customerService.calculateRewardsById(id);
        return customerService.getCustomerById(id);
    }

    // Deletes a customer
    @DeleteMapping("customers/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        return customerService.deleteCustomer(id);
    }
}
