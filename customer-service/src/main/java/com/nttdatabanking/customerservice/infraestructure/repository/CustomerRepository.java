package com.nttdatabanking.customerservice.infraestructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdatabanking.customerservice.infraestructure.entity.CustomerEntity;

public interface CustomerRepository extends ReactiveMongoRepository<CustomerEntity, String> {
}
