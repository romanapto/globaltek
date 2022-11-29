package com.dto.invoice;

import com.app.dto.invoice.InvoiceDTO;
import org.junit.Assert;
import org.junit.Test;


public class InvoiceDTOTest {

    @Test
    public void validateOrderDTO() {
        InvoiceDTO invoiceDTO = getInvoiceDTO();
        Assert.assertEquals("IdInvoice", invoiceDTO.getId());
        Assert.assertEquals(10, invoiceDTO.getTotal().intValue());
    }

    private InvoiceDTO getInvoiceDTO() {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId("IdInvoice");
        invoiceDTO.setTotal(10);
        return invoiceDTO;
    }

}
