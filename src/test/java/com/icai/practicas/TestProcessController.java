package com.icai.practicas;

import com.icai.practicas.controller.ProcessController;

import static org.assertj.core.api.BDDAssertions.then;

import com.icai.practicas.controller.ProcessController.DataResponse;


import com.icai.practicas.controller.ResponseHTMLGenerator;
import com.icai.practicas.service.ProcessService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestProcessController {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void datos_bien_introducidos_step1_then_message1() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        
        MultiValueMap<String, String> datos = new LinkedMultiValueMap<>();
        datos.add("fullName", "Ignacio");
        datos.add("dni", "05324971B");
        datos.add("telefono", "609354516");

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(datos, headers);
        //When
		
        var result = this.restTemplate.postForEntity(address, request, ResponseHTMLGenerator.class);
		        
        //Then
        String expectedResult = ResponseHTMLGenerator.message1;
		then(result.getBody()).isEqualTo(expectedResult); 
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    public void datos_mal_introducidos_step1_then_message2() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        
        
        MultiValueMap<String, String> datos = new LinkedMultiValueMap<>();
        datos.add("fullName", "Ignacio");
        datos.add("dni", "05324971B");
        datos.add("telefono", "4516");

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(datos, headers);
        //When
		
        var result = this.restTemplate.postForEntity(address, request, ResponseHTMLGenerator.class);
        
        //Then
        String expectedResult = ResponseHTMLGenerator.message2;
		
        
        then(result.getBody()).isEqualTo(expectedResult);
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
    
    
    @Test
    public void datos_bien_introducidos_step2_then_ok() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataRequest = new ProcessController.DataRequest("Ignacio", "05324971B", "609354516");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //When
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);
        var result = this.restTemplate.postForEntity(address, request, ProcessController.DataResponse.class);
        
        //Then
        String expectedResult = "OK";
        DataResponse expectedResponse = new DataResponse(expectedResult);
        
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(expectedResponse);
        //then(result.getBody().result()).isEqualTo(expectedResult);
    }
    

    @Test
    public void datos_mal_introducidos_step2_then_ko() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataRequest = new ProcessController.DataRequest("Ignacio", "05324971B", "4516");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //When
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);
        var result = this.restTemplate.postForEntity(address, request, ProcessController.DataResponse.class);
        
        //Then
        String expectedResult = "KO";
        DataResponse expectedResponse = new DataResponse(expectedResult);
        
        
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(expectedResponse);
        //then(result.getBody().result()).isEqualTo(expectedResult);
    }
    
}