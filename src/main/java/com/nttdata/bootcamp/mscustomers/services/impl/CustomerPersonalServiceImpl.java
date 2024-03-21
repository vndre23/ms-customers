package com.nttdata.bootcamp.mscustomers.services.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerPersonal;
import com.nttdata.bootcamp.mscustomers.repositories.CustomerPersonalRepository;
import com.nttdata.bootcamp.mscustomers.services.CustomerPersonalService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerPersonalServiceImpl implements CustomerPersonalService{


    private final CustomerPersonalRepository customerPersonalRepository;

    @Override
    public Flux<CustomerPersonal> findAll() {
        log.info("CustomerService findAll {}");
        return this.customerPersonalRepository.findAll();
    }

    @Override
    public Mono<CustomerPersonal> findById(String id) {
        log.info("CustomerService finById {} "+id);
        return this.customerPersonalRepository.findById(id);
    }

    @Override
    public Mono<CustomerPersonal> save(CustomerPersonal personal) {
        if(personal.getCreateAt()==null){
            personal.setCreateAt(new Date());
        }
        log.info("CustomerService save {}"+personal.getNumberDocument());
        return this.customerPersonalRepository.save(personal);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        log.info("CustomerService deleteById {}");
        return this.customerPersonalRepository.deleteById(id);
    }

    @Override
    public Mono<CustomerPersonal> findByNumberDocument(String numberDocument) {
        return this.customerPersonalRepository.findByNumberDocument(numberDocument);
    }

    
}
