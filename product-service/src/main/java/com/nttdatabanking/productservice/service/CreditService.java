package com.nttdatabanking.productservice.service;

import com.nttdatabanking.productservice.model.CreditCreateDto;
import com.nttdatabanking.productservice.model.CreditDetailDto;
import com.nttdatabanking.productservice.model.CreditMovementCreateDto;
import com.nttdatabanking.productservice.model.CreditMovementDetailDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz servicio credito.
 */
public interface CreditService {

    Flux<CreditDetailDto> getList(
            String customerid);

    Mono<CreditDetailDto> create(
            Mono<CreditCreateDto> creditCreateDto);

    Flux<CreditMovementDetailDto> getMovementList(
            String creditid);

    Mono<CreditMovementDetailDto> createMovement(
            Mono<CreditMovementCreateDto> creditMovementCreateDto);

}
