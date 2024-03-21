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

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerPersonal;
import com.nttdata.bootcamp.mscustomers.services.CustomerPersonalService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers/personal")
@AllArgsConstructor
public class CustomerPersonalController {

    
    private final CustomerPersonalService customerPersonalService;

    @GetMapping
    public Mono<ResponseEntity<Flux<CustomerPersonal>>> findAll(){
        return Mono.just(ResponseEntity.ok(this.customerPersonalService.findAll()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerPersonal>> findById(@PathVariable String id){
        return this.customerPersonalService.findById(id)
            .map( find -> ResponseEntity.ok(find))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Mono<ResponseEntity<CustomerPersonal>> save(@RequestBody CustomerPersonal personal){
        return this.customerPersonalService.save(personal).map( save -> ResponseEntity.status(HttpStatus.CREATED).body(save));

    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CustomerPersonal>> update(@PathVariable String id,@RequestBody CustomerPersonal personal){
        return this.customerPersonalService.findById(id)
            .flatMap(find -> {
                find.setAddress(personal.getAddress());
                find.setPhone(personal.getPhone());
                return this.customerPersonalService.save(find);
            }).map(save -> ResponseEntity.ok().body(save))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/number-document/{numberDocument}")
    public Mono<ResponseEntity<CustomerPersonal>> findByNumberDocument(@PathVariable String numberDocument){
        return this.customerPersonalService.findByNumberDocument(numberDocument)
            .map( find -> ResponseEntity.ok(find))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
