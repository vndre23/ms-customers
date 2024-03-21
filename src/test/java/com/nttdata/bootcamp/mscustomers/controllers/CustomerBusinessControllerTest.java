package com.nttdata.bootcamp.mscustomers.controllers;
import com.nttdata.bootcamp.mscustomers.models.documents.CustomerBusiness;
import com.nttdata.bootcamp.mscustomers.services.CustomerBusinessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerBusinessControllerTest {

    @InjectMocks
    private CustomerBusinessController customerBusinessController;

    @Mock
    private CustomerBusinessService customerBusinessService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        
        CustomerBusiness customerBusiness = new CustomerBusiness();
        when(customerBusinessService.findAll()).thenReturn(Flux.just(customerBusiness));

        
        Mono<ResponseEntity<Flux<CustomerBusiness>>> response = customerBusinessController.findAll();

       
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.block().getStatusCode());
    }

    @Test
    void testFindById() {
        String id = "1";
        CustomerBusiness customerBusiness = new CustomerBusiness();
        when(customerBusinessService.findById(id)).thenReturn(Mono.just(customerBusiness));

        // Act
        Mono<ResponseEntity<CustomerBusiness>> response = customerBusinessController.findById(id);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.block().getStatusCode());
    }
    
}
