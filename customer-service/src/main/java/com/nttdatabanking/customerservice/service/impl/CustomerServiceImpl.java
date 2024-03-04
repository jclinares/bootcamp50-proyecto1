package com.nttdatabanking.customerservice.service.impl;

import com.nttdatabanking.customerservice.infraestructure.repository.CustomerRepository;
import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerDetailDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import com.nttdatabanking.customerservice.service.CustomerService;
import com.nttdatabanking.customerservice.util.Messages;
import com.nttdatabanking.customerservice.util.mapper.CustomerMapper;
import com.nttdatabanking.customerservice.util.validation.CustomerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion servicio cliente.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<CustomerDetailDto> getList() {
        return customerRepository
                .findAll()
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<CustomerDetailDto> getById(
            String id) {
        return customerRepository
                .findById(id)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<CustomerDetailDto> create(
            Mono<CustomerCreateDto> customerCreateDto) {
        return customerCreateDto
                .filter(CustomerValidation::validateCustomer)
                .switchIfEmpty(Mono.error(new Error(Messages.ERRORCUSTOMERVALIDATION)))
                .map(CustomerMapper::toEntity)
                .flatMap(customerRepository::insert)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<CustomerDetailDto> update(
            Mono<CustomerUpdateDto> customerUpdateDto) {
        return customerUpdateDto
                .filter(CustomerValidation::validateCustomer)
                .switchIfEmpty(Mono.error(new Error(Messages.ERRORCUSTOMERVALIDATION)))
                .map(CustomerMapper::toEntity)
                .flatMap(customerRepository::save)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<Void> delete(
            String id) {
        return customerRepository
                .deleteById(id);
    }

}
