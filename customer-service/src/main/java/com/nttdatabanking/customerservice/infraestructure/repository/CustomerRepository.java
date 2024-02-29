package com.nttdatabanking.customerservice.infraestructure.repository;

import com.nttdatabanking.customerservice.infraestructure.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Interfaz repositorio cliente.
 */
public interface CustomerRepository extends ReactiveMongoRepository<CustomerEntity, String> {
}
