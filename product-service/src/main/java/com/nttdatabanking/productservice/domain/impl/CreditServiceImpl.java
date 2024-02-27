package com.nttdatabanking.productservice.domain.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdatabanking.productservice.domain.CreditService;
import com.nttdatabanking.productservice.domain.dto.CreditCreateDto;
import com.nttdatabanking.productservice.domain.dto.CreditDetailDto;
import com.nttdatabanking.productservice.domain.dto.CreditMovementCreateDto;
import com.nttdatabanking.productservice.domain.dto.CreditMovementDetailDto;
import com.nttdatabanking.productservice.infraestructure.entity.CreditMovementEntity;
import com.nttdatabanking.productservice.infraestructure.repository.CreditMovementRepository;
import com.nttdatabanking.productservice.infraestructure.repository.CreditRepository;
import com.nttdatabanking.productservice.util.Constants;
import com.nttdatabanking.productservice.util.Messages;
import com.nttdatabanking.productservice.util.mapper.CreditMapper;
import com.nttdatabanking.productservice.util.mapper.CreditMovementMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private CreditMovementRepository creditMovementRepository;

    @Override
    public Flux<CreditDetailDto> getList(String customerid) {
        return creditRepository.findByCustomerId(customerid)
                .map(CreditMapper::toDto);
    }

    @Override
    public Mono<CreditDetailDto> create(@Valid Mono<CreditCreateDto> creditCreateDto) {
        return creditCreateDto
                .flatMap(CreditServiceImpl::validate)
                .switchIfEmpty(Mono.error(new Error(Messages.ERROR_CREDIT_VALIDATION)))
                .map(CreditMapper::toEntity)
                .flatMap(creditRepository::insert)
                .map(CreditMapper::toDto);
    }

    @Override
    public Flux<CreditMovementDetailDto> getMovementList(String creditid) {
        return creditMovementRepository.findByCreditId(creditid)
                .map(CreditMovementMapper::toDto);
    }

    @Override
    public Mono<CreditMovementDetailDto> createMovement(@Valid Mono<CreditMovementCreateDto> creditMovementCreateDto) {
        return creditMovementCreateDto
                .flatMap(CreditServiceImpl::validate)
                .switchIfEmpty(Mono.error(new Error(Messages.ERROR_CREDITMOVEMENT_VALIDATION)))
                .map(CreditMovementMapper::toEntity)
                .flatMap(creditMovementRepository::insert)
                .flatMap(e -> updateCredit(e))
                .map(CreditMovementMapper::toDto);
    }

    private Mono<CreditMovementEntity> updateCredit(CreditMovementEntity creditMovementEntity) {
        return creditRepository.findById(creditMovementEntity.getCreditId())
                .flatMap(creditEntity -> {
                    creditEntity.setAvailableAmount(creditEntity.getAvailableAmount()
                            + creditMovementEntity.getAmount() * (creditMovementEntity
                                    .getMovementType().equalsIgnoreCase(
                                            Constants.CREDIT_MOVEMENT_PAYMENT)
                                                    ? 1
                                                    : -1));
                    return creditRepository.save(creditEntity).thenReturn(creditMovementEntity);
                });
    }

    private static Mono<CreditCreateDto> validate(CreditCreateDto creditCreateDto) {
        return Mono.just(creditCreateDto)
                .filter(dto -> dto.getCustomerId() != null
                        && dto.getCreditNumber() != null
                        && dto.getCreditType() != null
                        && dto.getAvailableAmount() != null)
                .filter(dto -> dto.getCreditType().equalsIgnoreCase(Constants.CREDIT_BUSINESS)
                        || dto.getCreditType().equalsIgnoreCase(Constants.CREDIT_PERSONAL)
                        || dto.getCreditType().equalsIgnoreCase(Constants.CREDIT_CREDITCARD));
    }

    private static Mono<CreditMovementCreateDto> validate(CreditMovementCreateDto creditMovementCreateDto) {
        return Mono.just(creditMovementCreateDto).filter(dto -> dto.getMovementType()
                .equalsIgnoreCase(Constants.CREDIT_MOVEMENT_PAYMENT)
                || dto.getMovementType().equalsIgnoreCase(Constants.CREDIT_MOVEMENT_CONSUMPTION));
    }

}
