package com.nttdata.bootcamp.mscustomers.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerPersonal;

import reactor.core.publisher.Mono;

public interface CustomerPersonalRepository extends ReactiveMongoRepository<CustomerPersonal,String>{

    public Mono<CustomerPersonal> findByNumberDocument(String numberDocument);
}
