package com.esprit.customerservice.mappers;

import com.esprit.customerservice.dto.CustomerRequestDTO;
import com.esprit.customerservice.dto.CustomerResponseDTO;
import com.esprit.customerservice.entities.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    // Si il y a des attributs qui differant alors une simple annotation ici @Mapping(source ="" , target = "")

    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOtoCustomer(CustomerRequestDTO customerRequestDTO);


}
