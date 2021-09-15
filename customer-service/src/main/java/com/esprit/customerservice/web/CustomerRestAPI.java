package com.esprit.customerservice.web;

import com.esprit.customerservice.dto.CustomerRequestDTO;
import com.esprit.customerservice.dto.CustomerResponseDTO;
import com.esprit.customerservice.entities.Customer;
import com.esprit.customerservice.services.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private ICustomerService iCustomerService;

    private static Logger logger = LoggerFactory.getLogger(CustomerRestAPI.class);

    public CustomerRestAPI(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> listCustomer(){
        logger.info("all customer ");
        return iCustomerService.listCustomer();
    }

    @GetMapping(path = "/customer/{id}")
    public CustomerResponseDTO findCustomer(@PathVariable String id){
        return iCustomerService.getCustomer(id);
    }

    @PostMapping(path = "/saveCustomer")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return iCustomerService.saveCustomer(customerRequestDTO);

    }
    @PutMapping(path = "/updateCustomer")
    public CustomerResponseDTO updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
            return     iCustomerService.updateCustomer(customerRequestDTO);
    }
    @DeleteMapping(path = "/deleteCustomer/{id}")
    public CustomerResponseDTO deleteCustomer(@PathVariable String id){
        return iCustomerService.deleteCustomer(id);
    }


}
