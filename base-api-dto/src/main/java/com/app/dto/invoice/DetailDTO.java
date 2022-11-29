package com.app.dto.invoice;

public class DetailDTO {

        private Integer idDetalle;
	private Integer idFactura;
        private Integer idProducto;
        private Integer Cantidad;
        private Integer PrecioUnitario;

        public Integer getIdDetalle() {
                    return idDetalle;
                }

        public void setIdDetalle(Integer idDetalle) {
            this.idDetalle = idDetalle;
        }

        public Integer getIdFactura() {
            return idFactura;
        }

        public void setIdFactura(Integer idFactura) {
            this.idFactura = idFactura;
        }

        public Integer getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(Integer idProducto) {
            this.idProducto = idProducto;
        }

        public Integer getCantidad() {
            return Cantidad;
        }

        public void setCantidad(Integer Cantidad) {
            this.Cantidad = Cantidad;
        }

        public Integer getPrecioUnitario() {
            return PrecioUnitario;
        }

        public void setPrecioUnitario(Integer PrecioUnitario) {
            this.PrecioUnitario = PrecioUnitario;
        }
}
