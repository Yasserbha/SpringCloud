package com.esprit.customerservice.services;

import com.esprit.customerservice.dto.CustomerRequestDTO;
import com.esprit.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface ICustomerService {

    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);
    public CustomerResponseDTO getCustomer(String id);
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO);
    public List<CustomerResponseDTO> listCustomer();
    public CustomerResponseDTO deleteCustomer(String id);
}
