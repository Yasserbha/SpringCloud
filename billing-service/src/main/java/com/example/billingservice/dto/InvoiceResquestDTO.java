package com.example.billingservice.dto;

import com.example.billingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

 @Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceResquestDTO {

    private BigDecimal amount;
    private String customerId;
    private Date date;
}
