package com.example.billingservice.services;

import com.example.billingservice.dto.InvoiceResponseDTO;
import com.example.billingservice.dto.InvoiceResquestDTO;
import com.example.billingservice.entities.Customer;
import com.example.billingservice.entities.Invoice;
import com.example.billingservice.mappers.InvoiceMapper;
import com.example.billingservice.openfeign.CustomerRestClient;
import com.example.billingservice.repositories.InvoiceRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements IInvoiceService{
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper = Mappers.getMapper(InvoiceMapper.class);
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO saveInvoice(InvoiceResquestDTO invoiceResquestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceResquestDTO);
        invoice.setId(UUID.randomUUID().toString());
        Invoice saveInvoice =  invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO deleteInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        invoiceRepository.delete(invoice);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public InvoiceResponseDTO updateInvoice(InvoiceResquestDTO invoiceResquestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceResquestDTO);
        Invoice invoice1update = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(invoice1update);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> listInvoices(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
        return invoices
                .stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
    }
}
