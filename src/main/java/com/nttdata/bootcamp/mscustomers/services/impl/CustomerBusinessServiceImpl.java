package com.nttdata.bootcamp.mscustomers.services.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerBusiness;
import com.nttdata.bootcamp.mscustomers.repositories.CustomerBusinessRepository;
import com.nttdata.bootcamp.mscustomers.services.CustomerBusinessService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class CustomerBusinessServiceImpl implements CustomerBusinessService{

    private final CustomerBusinessRepository customerBusinessRepository;

    @Override
    public Flux<CustomerBusiness> findAll() {
        return this.customerBusinessRepository.findAll();
    }

    @Override
    public Mono<CustomerBusiness> findById(String id) {
        return this.customerBusinessRepository.findById(id);
    }

    @Override
    public Mono<CustomerBusiness> save(CustomerBusiness business) {
        if(business.getCreatedAt()==null){
            business.setCreatedAt(new Date());
        }
        return this.customerBusinessRepository.save(business);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return this.customerBusinessRepository.deleteById(id);
    }

    @Override
    public Mono<CustomerBusiness> findByNumberDocument(String numberDocument) {
        return this.customerBusinessRepository.findByNumberDocument(numberDocument);
    }

}
