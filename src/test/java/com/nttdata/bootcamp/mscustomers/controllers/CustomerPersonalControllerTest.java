package com.nttdata.bootcamp.mscustomers.controllers;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerPersonal;
import com.nttdata.bootcamp.mscustomers.services.CustomerPersonalService;
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

public class CustomerPersonalControllerTest {

    @InjectMocks
    private CustomerPersonalController customerPersonalController;

    @Mock
    private CustomerPersonalService customerPersonalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {

        CustomerPersonal customerPersonal = new CustomerPersonal();
        when(customerPersonalService.findAll()).thenReturn(Flux.just(customerPersonal));


        Mono<ResponseEntity<Flux<CustomerPersonal>>> response = customerPersonalController.findAll();


        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.block().getStatusCode());
    }

    @Test
    void testFindById() {

        String id = "1";
        CustomerPersonal customerPersonal = new CustomerPersonal();
        when(customerPersonalService.findById(id)).thenReturn(Mono.just(customerPersonal));


        Mono<ResponseEntity<CustomerPersonal>> response = customerPersonalController.findById(id);


        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.block().getStatusCode());
    }

    @Test
    void testSave() {

        CustomerPersonal personal = new CustomerPersonal();
        when(customerPersonalService.save(personal)).thenReturn(Mono.just(personal));


        Mono<ResponseEntity<CustomerPersonal>> response = customerPersonalController.save(personal);


        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.block().getStatusCode());
    }

    @Test
    void testUpdate() {

        String id = "1";
        CustomerPersonal personal = new CustomerPersonal();
        when(customerPersonalService.findById(id)).thenReturn(Mono.just(personal));
        when(customerPersonalService.save(personal)).thenReturn(Mono.just(personal));


        Mono<ResponseEntity<CustomerPersonal>> response = customerPersonalController.update(id, personal);


        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.block().getStatusCode());
    }

    @Test
    void testFindByNumberDocument() {

        String numberDocument = "123456789";
        CustomerPersonal personal = new CustomerPersonal();
        when(customerPersonalService.findByNumberDocument(numberDocument)).thenReturn(Mono.just(personal));


        Mono<ResponseEntity<CustomerPersonal>> response = customerPersonalController.findByNumberDocument(numberDocument);


        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.block().getStatusCode());
    }
}