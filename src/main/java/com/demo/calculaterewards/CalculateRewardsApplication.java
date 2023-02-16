package com.demo.calculaterewards;

import com.demo.calculaterewards.model.Customer;
import com.demo.calculaterewards.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Random;

@SpringBootApplication
public class CalculateRewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateRewardsApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerService customerService){
		return args -> {

			for(int i=1;i<=100;i++){
				Random random = new Random();
				int number = random.nextInt(491) + 10;
				Customer customer = new Customer(i,"John "+i, number,0);
				customerService.createCustomer(customer);
				customerService.calculateRewardsById(customer.getId());
			}
			customerService.getCustomers().forEach(System.out::println);
		};
	}
}
