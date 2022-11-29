package com.dto.product;

import com.app.dto.product.ProductDTO;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductDTOTest {

    private static ValidatorFactory factory;

    private static Validator validator;

    @BeforeClass
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateProduct() {
        ProductDTO productDTO = getProductDTO();
        Assert.assertEquals("IdProduct", productDTO.getId());
        Assert.assertEquals("producto", productDTO.getProducto());
    }
    
    private ProductDTO getProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId("IdProduct");
        productDTO.setProducto("producto");
        return productDTO;
    }
    
    @Test
    public void validateWithNameInvalidNameSize() {
    	ProductDTO productDTO = getProductDTO();
    	productDTO.setProducto("setNamesetNamesetNamesetNamesetNamesetNamesetNamesetNameNamesetNamesetNamesetNamesetNamesetNamesetNamesetName");
        
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<ProductDTO> violation : violations) {
            Assert.assertEquals("error.name.size.max", violation.getMessage());
        }
    }
    
    @Test
    public void validateWithDescriptionEmpty() {
    	ProductDTO productDTO = getProductDTO();
    	productDTO.setProducto("");

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<ProductDTO> violation : violations) {
            Assert.assertEquals("", violation.getInvalidValue());
        }
    }
    
    
}
