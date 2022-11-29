package com.app.controller;

import com.app.dto.invoice.InvoiceDTO;
import com.app.persistence.model.es.invoice.Invoice;
import com.app.service.InvoiceService;
import com.app.util.ApiConstants;


import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(ApiConstants.BASE_ORDERS_URI)
@Api(value = "Invoices", tags = "Invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private Mapper mapper;

        /**
         * Servicio que consulta la informacion de una factura, adicional
         * se realiza control de circuit breaker 
         * @param invoiceId
         * @return 
         */
	@ApiOperation(value = "Get Invoice", tags = "Invoices")
	@RequestMapping(value = "{invoiceId}", method = RequestMethod.GET)
	public InvoiceDTO getOrder(@PathVariable String invoiceId) {
		Invoice invoice = invoiceService.findOne(invoiceId);
		return mapper.map(invoice, InvoiceDTO.class);
	}
        
        /**
         * servicio que crea una factura, adicional se realiza control con 
         * circuit breaker
         * @param invoiceDTO
         * @return 
         */
        @ApiOperation(value = "Create Invoice", tags = "Invoices")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public InvoiceDTO createInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {
		invoiceDTO.setId(null);
		Invoice invoice = invoiceService.saveNewInvoice(mapper.map(invoiceDTO, Invoice.class));
		return mapper.map(invoice, InvoiceDTO.class);
	}
        
        /**
         * servicio que actualiza una factura, adicional se realiza control con 
         * circuit breaker
         * @param invoiceId
         * @param invoiceDTO
         * @return 
         */
        @ApiOperation(value = "Update Invoice", tags = "Invoices")
	@RequestMapping(value = "{invoiceId}", method = RequestMethod.PUT)
	public InvoiceDTO updateInvoice(@PathVariable String invoiceId, @Valid @RequestBody InvoiceDTO invoiceDTO) {
		invoiceDTO.setId(invoiceId);
		Invoice invoice = invoiceService.updateInvoice(mapper.map(invoiceDTO, Invoice.class));
		return mapper.map(invoice, InvoiceDTO.class);
	}

	
}
