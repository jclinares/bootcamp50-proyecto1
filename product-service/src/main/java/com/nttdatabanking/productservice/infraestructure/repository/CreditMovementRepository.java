package com.nttdatabanking.productservice.infraestructure.repository;

import com.nttdatabanking.productservice.infraestructure.entity.CreditMovementEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Interfaz repositorio movimiento credito.
 */
public interface CreditMovementRepository
        extends ReactiveMongoRepository<CreditMovementEntity, String> {

    Flux<CreditMovementEntity> findByCreditId(String creditId);

}
