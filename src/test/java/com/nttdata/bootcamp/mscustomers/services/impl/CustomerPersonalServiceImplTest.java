package com.nttdata.bootcamp.mscustomers.services.impl;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerPersonal;
import com.nttdata.bootcamp.mscustomers.repositories.CustomerPersonalRepository;
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
public class CustomerPersonalServiceImplTest {

    @InjectMocks
    private CustomerPersonalServiceImpl customerPersonalService;

    @Mock
    private CustomerPersonalRepository customerPersonalRepository;

    @Test
    void testFindAll() {
        // Arrange
        CustomerPersonal customerPersonal = new CustomerPersonal();
        when(customerPersonalRepository.findAll()).thenReturn(Flux.just(customerPersonal));

        // Act
        Flux<CustomerPersonal> result = customerPersonalService.findAll();

        // Assert
        assertEquals(1, result.collectList().block().size());
    }

    @Test
    void testFindById() {
        // Arrange
        String id = "1";
        CustomerPersonal customerPersonal = new CustomerPersonal();
        when(customerPersonalRepository.findById(id)).thenReturn(Mono.just(customerPersonal));

        // Act
        Mono<CustomerPersonal> result = customerPersonalService.findById(id);

        // Assert
        assertEquals(customerPersonal, result.block());
    }

    // Similar tests for other service methods
}
