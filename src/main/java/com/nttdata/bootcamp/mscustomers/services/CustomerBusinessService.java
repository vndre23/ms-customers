package com.nttdata.bootcamp.mscustomers.services;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerBusiness;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerBusinessService {

    public Flux<CustomerBusiness> findAll();

    public Mono<CustomerBusiness> findById(String id);

    public Mono<CustomerBusiness> save(CustomerBusiness business);

    public Mono<Void> deleteById(String id);

    public Mono<CustomerBusiness> findByNumberDocument(String numberDocument);
}
