package com.app.controller;

import com.app.dto.product.ProductDTO;
import com.app.persistence.model.es.product.Product;
import com.app.service.ProductService;
import com.app.util.ApiConstants;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiConstants.BASE_PRODUCTS_URI)
@Api(value = "Products", tags = "Products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private Mapper mapper;
        
        /**
         * Servicio que consulta informacion de un producto y devuelve un json
         * con informacion del producto, se realiza control con circuit breaker
         * @param productId
         * @return 
         */
        @ApiOperation(value = "Get Product", tags = "Products")
	@RequestMapping(value = "{productId}", method = RequestMethod.GET)
	public ProductDTO getProduct(@PathVariable String productId) {
		Product product = productService.findOne(productId);
		return mapper.map(product, ProductDTO.class);
	}

        /**
         * Servicio que crea un producto y devuelve json con la informacion creada, el id del
         * producto se autogenera para manejar un estandar, se realiza control con circuit breaker
         * @param productDTO
         * @return 
         */
	@ApiOperation(value = "Create Product", tags = "Products")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
		productDTO.setId(null);
		Product product = productService.create(mapper.map(productDTO, Product.class));
		return mapper.map(product, ProductDTO.class);
	}

        /**
         * servicio que actualiza informacion de un producto, este servicio posee un control de 
         * validacion de existencia del producto para garantizar la actualizacion,
         * se realiza control con circuit breaker
         * @param productId
         * @param productDTO
         * @return 
         */
	@ApiOperation(value = "Update Product", tags = "Products")
	@RequestMapping(value = "{productId}", method = RequestMethod.PUT)
	public ProductDTO updateProduct(@PathVariable String productId, @Valid @RequestBody ProductDTO productDTO) {
		productDTO.setId(productId);
		Product product = productService.update(mapper.map(productDTO, Product.class));
		return mapper.map(product, ProductDTO.class);
	}
        


	
}
