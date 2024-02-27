package com.nttdatabanking.customerservice.domain.service;

import com.nttdatabanking.customerservice.domain.dto.CustomerCreateDto;
import com.nttdatabanking.customerservice.domain.dto.CustomerDetailDto;
import com.nttdatabanking.customerservice.domain.dto.CustomerUpdateDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<CustomerDetailDto> getList();

    Mono<CustomerDetailDto> getById(String id);

    Mono<CustomerDetailDto> create(Mono<CustomerCreateDto> customerCreateDto);

    Mono<CustomerDetailDto> update(Mono<CustomerUpdateDto> customerUpdateDto);

    Mono<Void> delete(String id);

}
