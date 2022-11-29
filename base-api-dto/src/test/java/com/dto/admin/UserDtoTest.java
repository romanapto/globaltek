package com.dto.admin;

import com.app.dto.admin.UserDTO;
import com.app.dto.admin.RoleDTO;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Arrays;
import java.util.Set;

public class UserDtoTest {

    private static ValidatorFactory factory;

    private static Validator validator;

    @BeforeClass
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //@Test
    public void validateOrganization() {
    	UserDTO userDTO = getUserDto();
        Assert.assertEquals(0, validator.validate(userDTO).size());
    }

    //@Test
    public void validateWithEmptyFirstName() {
    	UserDTO userDTO = getUserDto();
        userDTO.setFirstName("");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<UserDTO> violation : violations) {
            Assert.assertEquals("", violation.getInvalidValue());
        }
    }
    
    //@Test
    public void validateWithInvalidFirstNameSize() {
    	UserDTO userDTO = getUserDto();
        userDTO.setFirstName("Name Name Name Name Name Name.....");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<UserDTO> violation : violations) {
            Assert.assertEquals("error.firstname.size.max", violation.getMessage());
        }
    }

    //@Test
    public void validateWithEmptyLastName() {
    	UserDTO userDTO = getUserDto();
        userDTO.setLastName("");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<UserDTO> violation : violations) {
            Assert.assertEquals("", violation.getInvalidValue());
        }
    }
    
    //@Test
    public void validateWithInvalidLastNameSize() {
    	UserDTO userDTO = getUserDto();
        userDTO.setLastName("Name Name Name Name Name Name.....");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<UserDTO> violation : violations) {
            Assert.assertEquals("error.lastname.size.max", violation.getMessage());
        }
    }
    
    //@Test
    public void validateWithEmptyEmail() {
    	UserDTO userDTO = getUserDto();
        userDTO.setEmail("");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<UserDTO> violation : violations) {
            Assert.assertEquals("", violation.getInvalidValue());
        }
    }
    
    //@Test
    public void validateWithInvalidEmailSize() {
    	UserDTO userDTO = getUserDto();
        userDTO.setEmail("esteEsMiEmailExtraGrandeParaValidaresteEsMiEmailExtraGrandeParaValidaresteEsMiEmailExtraGrandeParaValidar@mailmailmailmailmailmail.com");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        Assert.assertEquals(1, violations.size());
        for (ConstraintViolation<UserDTO> violation : violations) {
            Assert.assertEquals("error.email.size.max", violation.getMessage());
        }
    }
    

    private UserDTO getUserDto() {
    	UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Organization name");
        userDTO.setLastName("Description");
        userDTO.setEmail("mail@mail.com");
        RoleDTO role = new RoleDTO();
        role.setId("IdRole");
        role.setDescription("DescriptionRole");
        role.setRoleName("RoleName");
        userDTO.setRoles(Arrays.asList(role));
        return userDTO;
    }
}
