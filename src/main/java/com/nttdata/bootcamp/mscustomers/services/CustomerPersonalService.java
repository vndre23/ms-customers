package com.nttdata.bootcamp.mscustomers.services;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerPersonal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerPersonalService {

    public Flux<CustomerPersonal> findAll();

    public Mono<CustomerPersonal> findById(String id);

    public Mono<CustomerPersonal> save(CustomerPersonal personal);

    public Mono<Void> deleteById(String id);

    public Mono<CustomerPersonal> findByNumberDocument(String numberDocument);
}
