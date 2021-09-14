package com.esprit.customerservice.web;

import com.esprit.customerservice.dto.CustomerRequestDTO;
import com.esprit.customerservice.dto.CustomerResponseDTO;
import com.esprit.customerservice.entities.Customer;
import com.esprit.customerservice.services.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private ICustomerService iCustomerService;

    public CustomerRestAPI(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> listCustomer(){
    return iCustomerService.listCustomer();
    }

    @GetMapping(path = "/customer/{id}")
    public CustomerResponseDTO findCustomer(@PathVariable String id){
        return iCustomerService.getCustomer(id);
    }

    @PostMapping(path = "/saveCustomer")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
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
