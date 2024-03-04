package com.nttdatabanking.productservice.service;

import com.nttdatabanking.productservice.model.AccountCreateDto;
import com.nttdatabanking.productservice.model.AccountDetailDto;
import com.nttdatabanking.productservice.model.AccountMovementCreateDto;
import com.nttdatabanking.productservice.model.AccountMovementDetailDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz servicio cuenta.
 */
public interface AccountService {

    Flux<AccountDetailDto> getList(
            String cutomerId);

    Mono<AccountDetailDto> create(
            Mono<AccountCreateDto> accountCreateDto);

    Flux<AccountMovementDetailDto> getMovementList(
            String accountId);

    Mono<AccountMovementDetailDto> createMovement(
            Mono<AccountMovementCreateDto> accountMovementCreateDto);

}
