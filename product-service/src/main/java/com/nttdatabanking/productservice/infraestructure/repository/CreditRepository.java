package com.nttdatabanking.productservice.infraestructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdatabanking.productservice.domain.dto.CreditDetailDto;
import com.nttdatabanking.productservice.infraestructure.entity.CreditEntity;

import reactor.core.publisher.Flux;

public interface CreditRepository extends ReactiveMongoRepository<CreditEntity, String> {

    Flux<CreditEntity> findByCustomerId(String customerid);
    
}
