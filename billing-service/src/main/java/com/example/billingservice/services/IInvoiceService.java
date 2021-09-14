package com.example.billingservice.services;

import com.example.billingservice.dto.InvoiceResponseDTO;
import com.example.billingservice.dto.InvoiceResquestDTO;

import java.util.List;

public interface IInvoiceService {
    public InvoiceResponseDTO saveInvoice(InvoiceResquestDTO invoiceResquestDTO);
    public InvoiceResponseDTO deleteInvoice(String invoiceId);
    public InvoiceResponseDTO updateInvoice(InvoiceResquestDTO invoiceResquestDTO);
    public InvoiceResponseDTO getInvoice(String invoiceId);
    public List<InvoiceResponseDTO> listInvoices(String customerId);

}
