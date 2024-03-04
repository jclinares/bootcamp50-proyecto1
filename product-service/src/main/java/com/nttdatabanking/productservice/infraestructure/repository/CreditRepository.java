package com.nttdatabanking.productservice.infraestructure.repository;

import com.nttdatabanking.productservice.infraestructure.entity.CreditEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Interfaz repositorio credito.
 */
public interface CreditRepository
        extends ReactiveMongoRepository<CreditEntity, String> {

    Flux<CreditEntity> findByCustomerId(String customerid);

}
