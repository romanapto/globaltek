package com.app.dto.product;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductDTO {

	private String id;
	@NotEmpty
	@Size(max = 100, message = "error.name.size.max")
	private String Producto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

        public String getProducto() {
            return Producto;
        }

        public void setProducto(String Producto) {
            this.Producto = Producto;
        }

	
}
