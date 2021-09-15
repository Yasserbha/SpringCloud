package com.example.billingservice;

import com.example.billingservice.dto.InvoiceResquestDTO;
import com.example.billingservice.services.IInvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner (IInvoiceService iInvoiceService){
        return args -> {
            iInvoiceService.saveInvoice(new InvoiceResquestDTO(BigDecimal.valueOf(23342),"iusgkdq",new Date()));
        };
    }

}
