package com.nttdata.bootcamp.mscustomers.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerBusiness;
import com.nttdata.bootcamp.mscustomers.services.CustomerBusinessService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers/business")
public class CustomerBusinessController {

    private final CustomerBusinessService customerBusinessService;

    @GetMapping
    public Mono<ResponseEntity<Flux<CustomerBusiness>>> findAll(){
        return Mono.just(ResponseEntity.ok(this.customerBusinessService.findAll()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerBusiness>> findById(@PathVariable String id){
        return this.customerBusinessService.findById(id)
            .map( find -> ResponseEntity.ok(find))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Mono<ResponseEntity<CustomerBusiness>> save(@RequestBody CustomerBusiness business){
        return this.customerBusinessService.save(business).map( save -> ResponseEntity.status(HttpStatus.CREATED).body(save));

    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CustomerBusiness>> update(@PathVariable String id,@RequestBody CustomerBusiness business){
        return this.customerBusinessService.findById(id)
            .flatMap(find -> {
                find.setAddress(business.getAddress());
                find.setPhone(business.getPhone());
                return this.customerBusinessService.save(find);
            }).map(save -> ResponseEntity.ok().body(save))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("number-document/{numberDocument}")
    public Mono<ResponseEntity<CustomerBusiness>> findByNumberDocument(@PathVariable String numberDocument){
        return this.customerBusinessService.findAll()
                .filter(customer ->customer.getNumberDocument().equals(numberDocument))
                .map(res -> ResponseEntity.ok(res))
                .next()
                .defaultIfEmpty(ResponseEntity.badRequest().build());

            // return this.customerBusinessService.findByNumberDocument(numberDocument)
            // .map(res -> ResponseEntity.ok(res))
            // .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
