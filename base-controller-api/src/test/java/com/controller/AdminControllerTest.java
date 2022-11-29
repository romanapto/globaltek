package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.controller.dto.ResponseLogin;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
public class AdminControllerTest {

    @LocalServerPort
    private int port;

    ObjectMapper mapper = new ObjectMapper();

    RestTemplate restTemplate = new RestTemplate();

    private static String token;

    private String url;
    
    private static final Logger LOG = LoggerFactory.getLogger(AdminControllerTest.class);

    //@BeforeClass
    public void login() throws IOException {   	
    	LOG.info("infoUser - antestoken: " + token);
        
        //url = "http://localhost:" + port;
        url = "http://localhost:" + 8091;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic ZGV2OmRldg==");

        HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

        ResponseEntity<ResponseLogin> response = restTemplate.postForEntity(url + "/api/v1/oauth/token?" +
                "grant_type=password&username=admin@admin.com&password=123456", request, ResponseLogin.class);

        token = response.getBody().getAccessToken();
        LOG.info("infoUser - token: " + token);
    }

    @Test
    public void consultaUser() throws IOException {
        login();
        //Configure test
        //ManagementUserDTO managementUserDTO = new ManagementUserDTO();
        //managementUserDTO.setId("oPmkGnkByhS-LPT8qZKQ");

        //String request = mapper.writeValueAsString(managementUserDTO);
        //Test
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);

        //HttpEntity<ManagementUserDTO> requestObject = new HttpEntity<>(managementUserDTO, headers);
        LOG.info("infoUser - prevvvvv: " );
        //ResponseEntity<ManagementUserDTO> response = restTemplate.exchange(url+"/api/v1/infousers/oPmkGnkByhS-LPT8qZKQ", HttpMethod.GET, requestObject, ManagementUserDTO.class);
        
        //LOG.info("infoUser - nameUser: " + response.getBody().getName());
        //Assert.assertEquals("julian", response.getBody().getName());
    }
    
    
}
