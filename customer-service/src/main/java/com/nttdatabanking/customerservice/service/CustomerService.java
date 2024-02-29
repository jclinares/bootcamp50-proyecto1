package com.nttdatabanking.customerservice.service;

import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerDetailDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz servicio cliente.
 */
public interface CustomerService {

    Flux<CustomerDetailDto> getList();

    Mono<CustomerDetailDto> getById(String id);

    Mono<CustomerDetailDto> create(Mono<CustomerCreateDto> customerCreateDto);

    Mono<CustomerDetailDto> update(Mono<CustomerUpdateDto> customerUpdateDto);

    Mono<Void> delete(String id);

}
