package com.nttdatabanking.productservice.infraestructure.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdatabanking.productservice.infraestructure.entity.AccountEntity;

import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveMongoRepository<AccountEntity, String> {

    @Query(value = "{ 'accountCustomer.customerId' : ?0 }")
    Flux<AccountEntity> findByCustomerId(String customerId);

}
