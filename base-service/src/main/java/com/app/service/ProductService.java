package com.app.service;

import com.app.persistence.model.es.product.Product;
import com.app.repository.es.ProductRepository;
import com.app.util.DateUtils;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;
        
        private static final String RESILIENCE4J_INSTANCE_NAME = "productService";

        @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod ="getNullProduct")
	public Product create(Product product) {
		String creationDate = DateUtils.nowTimestamp();
		product = productRepository.save(product);
		return product;
	}

	@CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod ="getNullProduct")
	@PreAuthorize("isProductReader(#product.id)")
	public Product update(Product product) {
		String updateDate = DateUtils.nowTimestamp();
		//product.setUpdateDate(updateDate);
		product = productRepository.save(product);

		return product;
	}

	@PreAuthorize("isProductReader(#product.id)")
	public void delete(Product product) {
		productRepository.delete(product);
	}

        @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod ="getNullProduct")
	public Product findOne(String productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
        
        
        public Product getNullProduct (Exception e){
            LOG.info(String.format("Facturacion - error Product CircuitBreaker/%s", e.getMessage()));
            return new Product();
        }

        


	
}