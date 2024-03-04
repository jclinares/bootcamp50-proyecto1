package com.nttdatabanking.productservice.api;

import com.nttdatabanking.productservice.model.AccountCreateDto;
import com.nttdatabanking.productservice.model.AccountDetailDto;
import com.nttdatabanking.productservice.model.AccountMovementCreateDto;
import com.nttdatabanking.productservice.model.AccountMovementDetailDto;
import com.nttdatabanking.productservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion delegado api cuenta.
 */
@Slf4j
@Service
public class AccountApiDelegateImpl implements AccountApiDelegate {

    @Autowired
    AccountService accountService;

    @Override
    public Mono<ResponseEntity<Flux<AccountDetailDto>>> accountgetlist(
            String customerid, ServerWebExchange exchange) {
        log.info("accountgetlist start");
        log.info("customerid: {}", customerid);
        return accountService.getList(customerid)
                .collectList()
                .map(result -> ResponseEntity.ok(Flux.fromIterable(result)))
                .doFinally(signal -> log.info("accountgetlist end"));
    }

    @Override
    public Mono<ResponseEntity<AccountDetailDto>> accountcreate(
            Mono<AccountCreateDto> accountCreateDto, ServerWebExchange exchange) {
        log.info("accountcreate start");
        log.info("accountCreateDto: {}", accountCreateDto);
        return accountService.create(accountCreateDto)
                .map(ResponseEntity::ok)
                .doFinally(signal -> log.info("accountcreate end"));
    }

    @Override
    public Mono<ResponseEntity<Flux<AccountMovementDetailDto>>> accountmovementgetlist(
            String accountid, ServerWebExchange exchange) {
        log.info("accountmovementgetlist start");
        return accountService.getMovementList(accountid)
                .collectList()
                .map(result -> ResponseEntity.ok(Flux.fromIterable(result)))
                .doFinally(signal -> log.info("accountmovementgetlist end"));
    }

    @Override
    public Mono<ResponseEntity<AccountMovementDetailDto>> accountmovementcreate(
            Mono<AccountMovementCreateDto> accountMovementCreateDto, ServerWebExchange exchange) {
        log.info("accountmovementcreate start");
        log.info("accountMovementCreateDto: {}", accountMovementCreateDto);
        return accountService.createMovement(accountMovementCreateDto)
                .map(ResponseEntity::ok)
                .doFinally(signal -> log.info("accountmovementcreate end"));
    }

}
