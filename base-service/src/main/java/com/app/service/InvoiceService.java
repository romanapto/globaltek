package com.app.service;

import com.app.persistence.model.es.invoice.Invoice;
import com.app.repository.es.InvoiceRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

	private static final Logger LOG = LoggerFactory.getLogger(InvoiceService.class);
        
        private static final String RESILIENCE4J_INSTANCE_NAME = "invoiceService";

	@Autowired
	private InvoiceRepository invoiceRepository;
        
	@PreAuthorize("isInvoiceReader(#invoice.id)")
        @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod ="getNullInvoice")
	public void delete(Invoice invoice) {
		invoiceRepository.delete(invoice);
	}

        @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod ="getNullInvoice")
	public Invoice findOne(String id) {
		return invoiceRepository.findById(id).get();
	}

        @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod ="getNullInvoice")
	public Invoice saveNewInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
                return invoice;
	}
        
        @PreAuthorize("isInvoiceReader(#invoice.id)")
        @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod ="getNullInvoice")
	public Invoice updateInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
                return invoice;
	}
        
        public Invoice getNullInvoice (Exception e){
            LOG.info(String.format("Facturacion - error Invoice CircuitBreaker/%s", e.getMessage()));
            return new Invoice();
        }

	
}
