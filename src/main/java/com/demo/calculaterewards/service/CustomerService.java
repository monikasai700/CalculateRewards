package com.demo.calculaterewards.service;

import com.demo.calculaterewards.CustomerDTO;
import com.demo.calculaterewards.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Optional<Customer> calculateRewardsById(long id);
    public List<Customer> getCustomers();
    public Optional<Customer> getCustomerById(long id);
    public void createCustomer(Customer customer);
    public Customer updateCustomer(long id, Customer customer);
    public CustomerDTO getCustomerRewards(long id);
    public String deleteCustomer(long id);
}
