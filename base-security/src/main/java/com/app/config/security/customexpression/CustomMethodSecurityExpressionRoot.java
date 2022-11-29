package com.app.config.security.customexpression;


import com.app.persistence.model.es.invoice.Invoice;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import com.app.persistence.model.es.product.Product;
import com.app.repository.es.InvoiceRepository;
import com.app.repository.es.UserRepository;
import com.app.repository.es.ProductRepository;
import java.util.Optional;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot
		implements MethodSecurityExpressionOperations {

        private ProductRepository productRepository;
        
        private InvoiceRepository invoiceRepository;

	private Object filterObject;
	private Object returnObject;
	private Object target;

	public CustomMethodSecurityExpressionRoot(Authentication authentication, 
			UserRepository userRepository, 
                        ProductRepository productRepository
                        ,InvoiceRepository invoiceRepository
                        ) {
		super(authentication);
                this.productRepository = productRepository;
                this.invoiceRepository = invoiceRepository;
	}

        
        public boolean isProductReader(String productId) {
                Optional<Product> product = productRepository.findById(productId);
		return product.isPresent();
	}
        
        public boolean isInvoiceReader(String invoiceId) {
                Optional<Invoice> order = invoiceRepository.findById(invoiceId);
		return order.isPresent();
	}

	@Override
	public void setFilterObject(Object filterObject) {
		this.filterObject = filterObject;
	}

	@Override
	public Object getFilterObject() {
		return filterObject;
	}

	@Override
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	@Override
	public Object getReturnObject() {
		return returnObject;
	}

	void setThis(Object target) {
		this.target = target;
	}

	@Override
	public Object getThis() {
		return target;
	}
}
