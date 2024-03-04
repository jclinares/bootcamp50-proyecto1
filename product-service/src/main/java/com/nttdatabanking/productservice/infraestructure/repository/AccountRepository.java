package com.nttdatabanking.productservice.infraestructure.repository;

import com.nttdatabanking.productservice.infraestructure.entity.AccountEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Interfaz repositorio cuenta.
 */
public interface AccountRepository
        extends ReactiveMongoRepository<AccountEntity, String> {

    @Query(value = "{ 'customerList.customerId' : ?0 }")
    Flux<AccountEntity> findByCustomerId(String customerId);

}
