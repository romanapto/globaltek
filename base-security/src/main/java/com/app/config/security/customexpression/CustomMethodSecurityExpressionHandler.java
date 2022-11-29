package com.app.config.security.customexpression;

import com.app.repository.es.InvoiceRepository;
import com.app.repository.es.ProductRepository;
import com.app.repository.es.UserRepository;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;


public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
        
        private ProductRepository productRepository;
	private UserRepository userRepository;
        private InvoiceRepository invoiceRepository;
	

	private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

	public CustomMethodSecurityExpressionHandler(ProductRepository productRepository, 
                        UserRepository userRepository, InvoiceRepository InvoiceRepository) {
		this.productRepository = productRepository;
		this.userRepository = userRepository;
                this.invoiceRepository = InvoiceRepository;
	}

	@Override
	protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
			MethodInvocation invocation) {
		CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication,
				userRepository,productRepository,invoiceRepository);
		root.setPermissionEvaluator(getPermissionEvaluator());
		root.setTrustResolver(this.trustResolver);
		root.setRoleHierarchy(getRoleHierarchy());
		return root;
	}

	
}
