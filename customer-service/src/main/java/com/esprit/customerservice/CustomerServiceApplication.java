package com.esprit.customerservice;

import com.esprit.customerservice.dto.CustomerRequestDTO;
import com.esprit.customerservice.services.ICustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
@Bean
CommandLineRunner runner (ICustomerService iCustomerService){
        return  args -> {
            iCustomerService.saveCustomer(new CustomerRequestDTO("iusgkdq","yasser","yasserbha"));
            iCustomerService.saveCustomer(new CustomerRequestDTO("fzfddsq","lina","linabha"));
        };
}

}
