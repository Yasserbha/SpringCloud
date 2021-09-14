package com.esprit.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "CUSTOMER") @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer {
    @Id
    @Column(name = "ID")
    private String id ;
    private String name ;
    private String email;

}
