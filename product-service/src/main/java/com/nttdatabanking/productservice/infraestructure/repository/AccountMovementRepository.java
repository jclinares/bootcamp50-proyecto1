package com.nttdatabanking.productservice.infraestructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;

import reactor.core.publisher.Flux;

public interface AccountMovementRepository extends ReactiveMongoRepository<AccountMovementEntity, String> {

    Flux<AccountMovementEntity> findByAccountId(String accountId);

}
