package com.nttdatabanking.productservice.service.impl;

import com.nttdatabanking.productservice.infraestructure.entity.CreditMovementEntity;
import com.nttdatabanking.productservice.infraestructure.repository.CreditMovementRepository;
import com.nttdatabanking.productservice.infraestructure.repository.CreditRepository;
import com.nttdatabanking.productservice.model.CreditCreateDto;
import com.nttdatabanking.productservice.model.CreditDetailDto;
import com.nttdatabanking.productservice.model.CreditMovementCreateDto;
import com.nttdatabanking.productservice.model.CreditMovementDetailDto;
import com.nttdatabanking.productservice.service.CreditService;
import com.nttdatabanking.productservice.util.Messages;
import com.nttdatabanking.productservice.util.enumeration.CreditMovementTypeEnum;
import com.nttdatabanking.productservice.util.mapper.CreditMapper;
import com.nttdatabanking.productservice.util.mapper.CreditMovementMapper;
import com.nttdatabanking.productservice.util.validation.CreditValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion servicio credito.
 */
@Service
public class CreditServiceImpl implements CreditService {

        @Autowired
        private CreditValidation creditValidation;

        @Autowired
        private CreditRepository creditRepository;

        @Autowired
        private CreditMovementRepository creditMovementRepository;

        @Override
        public Flux<CreditDetailDto> getList(
                        String customerid) {
                return creditRepository
                                .findByCustomerId(customerid)
                                .map(CreditMapper::toDto);
        }

        @Override
        public Mono<CreditDetailDto> create(
                        Mono<CreditCreateDto> creditCreateDto) {
                return creditCreateDto
                                .filter(dto -> creditValidation.validateCredit(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.CREDITVALIDATIONERROR)))
                                .flatMap(dto -> creditValidation.validateDbCredit(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.CREDITDBVALIDATIONERROR)))
                                .map(CreditMapper::toEntity)
                                .flatMap(creditRepository::insert)
                                .map(CreditMapper::toDto);
        }

        @Override
        public Flux<CreditMovementDetailDto> getMovementList(
                        String creditId) {
                return creditMovementRepository
                                .findByCreditId(creditId)
                                .map(CreditMovementMapper::toDto);
        }

        @Override
        public Mono<CreditMovementDetailDto> createMovement(
                        Mono<CreditMovementCreateDto> creditMovementCreateDto) {
                return creditMovementCreateDto
                                .filter(dto -> creditValidation.validateCreditMovement(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.ERRORCREDITMOVEMENTVALIDATION)))
                                .map(CreditMovementMapper::toEntity)
                                .flatMap(creditMovementRepository::insert)
                                .flatMap(e -> updateCredit(e))
                                .map(CreditMovementMapper::toDto);
        }

        private Mono<CreditMovementEntity> updateCredit(
                        CreditMovementEntity creditMovementEntity) {
                return creditRepository
                                .findById(creditMovementEntity.getCreditId())
                                .flatMap(creditEntity -> {
                                        creditEntity.setAvailableAmount(creditEntity.getAvailableAmount()
                                                        + creditMovementEntity.getAmount() * (creditMovementEntity
                                                                        .getMovementType().equalsIgnoreCase(
                                                                                        CreditMovementTypeEnum.PAYMENT
                                                                                                        .getDescription())
                                                                                                                        ? 1
                                                                                                                        : -1));
                                        return creditRepository.save(creditEntity).thenReturn(creditMovementEntity);
                                });
        }

}
