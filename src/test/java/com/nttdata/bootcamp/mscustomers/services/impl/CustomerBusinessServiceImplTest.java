package com.nttdata.bootcamp.mscustomers.services.impl;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerBusiness;
import com.nttdata.bootcamp.mscustomers.repositories.CustomerBusinessRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerBusinessServiceImplTest {

    @InjectMocks
    private CustomerBusinessServiceImpl customerBusinessService;

    @Mock
    private CustomerBusinessRepository customerBusinessRepository;

    @Test
    void testFindAll() {
        // Arrange
        CustomerBusiness customerBusiness = new CustomerBusiness();
        when(customerBusinessRepository.findAll()).thenReturn(Flux.just(customerBusiness));

        // Act
        Flux<CustomerBusiness> result = customerBusinessService.findAll();

        // Assert
        assertEquals(1, result.collectList().block().size());
    }

    @Test
    void testFindById() {
        // Arrange
        String id = "1";
        CustomerBusiness customerBusiness = new CustomerBusiness();
        when(customerBusinessRepository.findById(id)).thenReturn(Mono.just(customerBusiness));

        // Act
        Mono<CustomerBusiness> result = customerBusinessService.findById(id);

        // Assert
        assertEquals(customerBusiness, result.block());
    }

    // Similar tests for other service methods
}