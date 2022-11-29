package com.app.persistence.model.es.invoice;

import com.app.persistence.model.es.product.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "sc-invoice")
public class Invoice implements Cloneable {

        @Id
	@Field(type = FieldType.Keyword)
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
        private Detail detail;
        private Product product;
	
	
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

        public Detail getDetail() {
            return detail;
        }

        public void setDetail(Detail detail) {
            this.detail = detail;
        }
        
        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
        
        @Override
	public Invoice clone() {
		try {
			Invoice inventory = (Invoice) super.clone();
			return inventory;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
