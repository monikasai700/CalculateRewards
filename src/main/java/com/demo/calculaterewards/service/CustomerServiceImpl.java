package com.demo.calculaterewards.service;

import com.demo.calculaterewards.CustomerDTO;
import com.demo.calculaterewards.model.Customer;
import com.demo.calculaterewards.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> calculateRewardsById(long id) {
        Optional<Customer> customerData = customerRepository.findById(id);
        if(customerData.isPresent()){
            Customer customer = customerData.get();
            long amount = customer.getAmount();
            long rewards = 0;

            if (amount > 100) {
                rewards += (amount - 100) * 2;
                amount = 100;
            }
            if (amount >= 50 && amount <= 100) {
                rewards += (amount - 50);
            }
            customer.setRewards(rewards);
            customerRepository.save(customer);
        }

        return customerData;

    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(long id,Customer customer) {
        Optional<Customer> customerData = customerRepository.findById(id);
        Customer customer1 = customerData.get();
        customer1.setName(customer.getName());
        customer1.setAmount(customer.getAmount());
        customerRepository.save(customer1);
        return customer1;
    }

    @Override
    public CustomerDTO getCustomerRewards(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        long custid = customer.get().getId();
        String name = customer.get().getName();
        return new CustomerDTO(custid,name,0);
    }

    @Override
    public String deleteCustomer(long id) {
        customerRepository.deleteById(id);
        return "Customer deleted successfully!";
    }


}
