package com.example.billingservice.mappers;

import com.example.billingservice.dto.InvoiceResponseDTO;
import com.example.billingservice.dto.InvoiceResquestDTO;
import com.example.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceResquestDTO invoiceResquestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);


}
