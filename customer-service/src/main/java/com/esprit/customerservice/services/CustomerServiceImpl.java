package com.esprit.customerservice.services;

import com.esprit.customerservice.dto.CustomerRequestDTO;
import com.esprit.customerservice.dto.CustomerResponseDTO;
import com.esprit.customerservice.entities.Customer;
import com.esprit.customerservice.mappers.CustomerMapper;
import com.esprit.customerservice.repositories.CustomerRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService{

    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {

/*
        Mapping Object to object

        Customer customer = new Customer();
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setName(customerRequestDTO.getName());


       Customer customersaved = customerRepository.save(customer);
       CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setEmail(customersaved.getEmail());
        customerResponseDTO.setName(customersaved.getName());
        */
        // remplace par
        Customer customer = customerMapper.customerRequestDTOtoCustomer(customerRequestDTO);
       // customer.setId(UUID.randomUUID().toString());
        Customer customerSaved = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customerSaved);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOtoCustomer(customerRequestDTO);
        Customer customerUpdate = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(customerUpdate);
    }

    @Override
    public List<CustomerResponseDTO> listCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS = customers.stream()
                .map(cust->customerMapper.customerToCustomerResponseDTO(cust))
                .collect(Collectors.toList());
        return customerResponseDTOS;
    }

    @Override
    public CustomerResponseDTO deleteCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
        return customerMapper.customerToCustomerResponseDTO(customer);
    }
}

