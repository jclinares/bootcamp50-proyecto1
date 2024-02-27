package com.nttdatabanking.productservice.infraestructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdatabanking.productservice.infraestructure.entity.CreditMovementEntity;

import reactor.core.publisher.Flux;

public interface CreditMovementRepository extends ReactiveMongoRepository<CreditMovementEntity, String> {

    Flux<CreditMovementEntity> findByCreditId(String creditId);

}
