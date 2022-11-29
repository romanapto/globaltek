package com.app.dto.invoice;

import com.app.dto.product.ProductDTO;

public class InvoiceDTO {

        private String id;
	private Integer NumeroFactura;
        private String Fecha;
        private String TipodePago;
        private String DocumentoCliente;
        private String NombreCliente;
        private Integer Subtotal;
        private Integer Descuento;
        private Integer IVA;
        private Integer TotalDescuento;
        private Integer TotalImpuesto;
        private Integer Total;
        private DetailDTO detailDto;
        private ProductDTO product;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getNumeroFactura() {
            return NumeroFactura;
        }

        public void setNumeroFactura(Integer NumeroFactura) {
            this.NumeroFactura = NumeroFactura;
        }

        public String getFecha() {
            return Fecha;
        }

        public void setFecha(String Fecha) {
            this.Fecha = Fecha;
        }

        public String getTipodePago() {
            return TipodePago;
        }

        public void setTipodePago(String TipodePago) {
            this.TipodePago = TipodePago;
        }

        public String getDocumentoCliente() {
            return DocumentoCliente;
        }

        public void setDocumentoCliente(String DocumentoCliente) {
            this.DocumentoCliente = DocumentoCliente;
        }

        public String getNombreCliente() {
            return NombreCliente;
        }

        public void setNombreCliente(String NombreCliente) {
            this.NombreCliente = NombreCliente;
        }

        public Integer getSubtotal() {
            return Subtotal;
        }

        public void setSubtotal(Integer Subtotal) {
            this.Subtotal = Subtotal;
        }

        public Integer getDescuento() {
            return Descuento;
        }

        public void setDescuento(Integer Descuento) {
            this.Descuento = Descuento;
        }

        public Integer getIVA() {
            return IVA;
        }

        public void setIVA(Integer IVA) {
            this.IVA = IVA;
        }

        public Integer getTotalDescuento() {
            return TotalDescuento;
        }

        public void setTotalDescuento(Integer TotalDescuento) {
            this.TotalDescuento = TotalDescuento;
        }

        public Integer getTotalImpuesto() {
            return TotalImpuesto;
        }

        public void setTotalImpuesto(Integer TotalImpuesto) {
            this.TotalImpuesto = TotalImpuesto;
        }

        public Integer getTotal() {
            return Total;
        }

        public void setTotal(Integer Total) {
            this.Total = Total;
        }

        public DetailDTO getDetailDto() {
            return detailDto;
        }

        public void setDetailDto(DetailDTO detailDto) {
            this.detailDto = detailDto;
        }   

        public ProductDTO getProduct() {
            return product;
        }

        public void setProduct(ProductDTO product) {
            this.product = product;
        }

	
}
