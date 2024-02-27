package com.nttdatabanking.productservice.domain;

import com.nttdatabanking.productservice.domain.dto.AccountCreateDto;
import com.nttdatabanking.productservice.domain.dto.AccountDetailDto;
import com.nttdatabanking.productservice.domain.dto.AccountMovementCreateDto;
import com.nttdatabanking.productservice.domain.dto.AccountMovementDetailDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Flux<AccountDetailDto> getList(String cutomerId);

    Mono<AccountDetailDto> create(Mono<AccountCreateDto> accountCreateDto);

    Flux<AccountMovementDetailDto> getMovementList(String accountId);

    Mono<AccountMovementDetailDto> createMovement(Mono<AccountMovementCreateDto> accountMovementCreateDto);

}
