package com.nttdatabanking.productservice.infraestructure.repository;

import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Interfaz repositorio movimiento cuenta.
 */
public interface AccountMovementRepository
        extends ReactiveMongoRepository<AccountMovementEntity, String> {

    Flux<AccountMovementEntity> findByAccountId(String accountId);

}
