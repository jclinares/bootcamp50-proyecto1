package com.nttdatabanking.productservice.infraestructure.repository;

import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz repositorio movimiento cuenta.
 */
public interface AccountMovementRepository
        extends ReactiveMongoRepository<AccountMovementEntity, String> {

    Flux<AccountMovementEntity> findByAccountId(String accountId);

    @Query(value = "{ 'accountId' : ?0 }", count = true)
    Mono<Long> countByAccountId(String accountId);

    @Query(value = "{ 'accountId' : ?0, 'movementDate' : { $regex: ?1, $options: 'i' } }", count = true)
    Mono<Long> countByAccountIdAndMovementMonth(String accountId, String movementMonth);

}
