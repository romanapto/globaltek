package com.dto.admin;

import com.app.dto.admin.RoleDTO;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RoleDtoTest {

    private static ValidatorFactory factory;

    private static Validator validator;

    @BeforeClass
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //@Test
    public void validateRoleName() {
        RoleDTO roleDTO = getRoleDto();
        Assert.assertEquals(0, validator.validate(roleDTO).size());
    }

    //@Test
    public void validateWithInvalidName() {
    	RoleDTO roleDTO = getRoleDto();
    	roleDTO.setRoleName("");

        Set<ConstraintViolation<RoleDTO>> violations = validator.validate(roleDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<RoleDTO> violation : violations) {
            Assert.assertEquals("", violation.getInvalidValue());
        }
    }

    private RoleDTO getRoleDto() {
    	RoleDTO roleDTO = new RoleDTO();
    	roleDTO.setDescription("Description");
    	roleDTO.setRoleName("ROLE_USER");
        return roleDTO;
    }
}
