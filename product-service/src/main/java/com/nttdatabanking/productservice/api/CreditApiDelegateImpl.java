package com.nttdatabanking.productservice.api;

import com.nttdatabanking.productservice.model.CreditCreateDto;
import com.nttdatabanking.productservice.model.CreditDetailDto;
import com.nttdatabanking.productservice.model.CreditMovementCreateDto;
import com.nttdatabanking.productservice.model.CreditMovementDetailDto;
import com.nttdatabanking.productservice.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion delegado api credito.
 */
@Slf4j
@Service
public class CreditApiDelegateImpl implements CreditApiDelegate {

    @Autowired
    CreditService creditService;

    @Override
    public Mono<ResponseEntity<Flux<CreditDetailDto>>> creditgetlist(
            String customerid, ServerWebExchange exchange) {
        log.info("creditgetlist start");
        return creditService.getList(customerid)
                .collectList()
                .map(result -> ResponseEntity.ok(Flux.fromIterable(result)))
                .doFinally(signal -> log.info("creditgetlist end"));
    }

    @Override
    public Mono<ResponseEntity<CreditDetailDto>> creditcreate(
            Mono<CreditCreateDto> creditCreateDto, ServerWebExchange exchange) {
        log.info("creditcreate start");
        log.info("creditCreateDto: {}", creditCreateDto);
        return creditService.create(creditCreateDto)
                .map(ResponseEntity::ok)
                .doFinally(signal -> log.info("creditcreate end"));
    }

    @Override
    public Mono<ResponseEntity<Flux<CreditMovementDetailDto>>> creditmovementgetlist(
            String creditid, ServerWebExchange exchange) {
        log.info("creditmovementgetlist start");
        return creditService.getMovementList(creditid)
                .collectList()
                .map(result -> ResponseEntity.ok(Flux.fromIterable(result)))
                .doFinally(signal -> log.info("creditmovementgetlist end"));
    }

    @Override
    public Mono<ResponseEntity<CreditMovementDetailDto>> creditmovementcreate(
            Mono<CreditMovementCreateDto> creditMovementCreateDto, ServerWebExchange exchange) {
        log.info("creditmovementcreate start");
        log.info("creditMovementCreateDto: {}", creditMovementCreateDto);
        return creditService.createMovement(creditMovementCreateDto)
                .map(ResponseEntity::ok)
                .doFinally(signal -> log.info("creditmovementcreate end"));
    }

}
