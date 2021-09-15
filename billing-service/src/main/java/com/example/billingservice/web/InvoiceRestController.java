package com.example.billingservice.web;

import com.example.billingservice.dto.InvoiceResponseDTO;
import com.example.billingservice.dto.InvoiceResquestDTO;
import com.example.billingservice.services.IInvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceRestController {
    private IInvoiceService iInvoiceService;

    public InvoiceRestController(IInvoiceService iInvoiceService) {
        this.iInvoiceService = iInvoiceService;
    }


    @GetMapping(path = "/invoice/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){
       return iInvoiceService.getInvoice(id);
    }
    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> listInvoice(@PathVariable(name = "customerId") String customerId){
        return iInvoiceService.listInvoices(customerId);
    }
    @PostMapping(path = "/saveInvoice")
    public InvoiceResponseDTO saveInvoice(@RequestBody InvoiceResquestDTO invoiceResquestDTO){
        return iInvoiceService.saveInvoice(invoiceResquestDTO);
    }
    @PutMapping(path = "/updateInvoice")
    public InvoiceResponseDTO updateInvoice(InvoiceResquestDTO invoiceResquestDTO){
        return iInvoiceService.updateInvoice(invoiceResquestDTO);
    }
    @DeleteMapping(path = "/deleteInvoice/{id}")
    public InvoiceResponseDTO deleteInvoice(@PathVariable(name = "id")String id){
        return iInvoiceService.deleteInvoice(id);
    }
    @GetMapping(path = "/listInvoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return iInvoiceService.allInvoices();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }





}
