package com.example.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Invoice {
    @Id
    private String id ;
    private Date date;
    private BigDecimal amount;
    private String customerId;
    @Transient //ignore par JPA
    private Customer customer;
}
