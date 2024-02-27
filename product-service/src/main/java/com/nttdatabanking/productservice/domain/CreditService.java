package com.nttdatabanking.productservice.domain;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.nttdatabanking.productservice.domain.dto.CreditCreateDto;
import com.nttdatabanking.productservice.domain.dto.CreditDetailDto;
import com.nttdatabanking.productservice.domain.dto.CreditMovementCreateDto;
import com.nttdatabanking.productservice.domain.dto.CreditMovementDetailDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {

    Mono<CreditDetailDto> create(@Valid Mono<CreditCreateDto> creditCreateDto);

    Flux<CreditDetailDto> getList(String customerid);

    Mono<CreditMovementDetailDto> createMovement(@Valid Mono<CreditMovementCreateDto> creditMovementCreateDto);

    Flux<CreditMovementDetailDto> getMovementList(String creditid);

}
