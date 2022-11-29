package com.app.persistence.model.es.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "sc-product")
public class Product implements Cloneable {

	@Id
	@Field(type = FieldType.Keyword)
	private String id;
	@Field(type = FieldType.Text)
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
        
	@Override
	public Product clone() {
		try {
			Product product = (Product) super.clone();
			return product;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
