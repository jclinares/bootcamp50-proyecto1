package com.nttdatabanking.productservice.service.impl;

import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;
import com.nttdatabanking.productservice.infraestructure.repository.AccountMovementRepository;
import com.nttdatabanking.productservice.infraestructure.repository.AccountRepository;
import com.nttdatabanking.productservice.model.AccountCreateDto;
import com.nttdatabanking.productservice.model.AccountDetailDto;
import com.nttdatabanking.productservice.model.AccountMovementCreateDto;
import com.nttdatabanking.productservice.model.AccountMovementDetailDto;
import com.nttdatabanking.productservice.service.AccountService;
import com.nttdatabanking.productservice.util.Messages;
import com.nttdatabanking.productservice.util.enumeration.AccountMovementTypeEnum;
import com.nttdatabanking.productservice.util.mapper.AccountMapper;
import com.nttdatabanking.productservice.util.mapper.AccountMovementMapper;
import com.nttdatabanking.productservice.util.validation.AccountValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion servicio cuenta.
 */
@Service
public class AccountServiceImpl implements AccountService {

        @Autowired
        private AccountValidation accountValidation;

        @Autowired
        private AccountRepository accountRepository;

        @Autowired
        private AccountMovementRepository accountMovementRepository;

        @Override
        public Flux<AccountDetailDto> getList(
                        String cutomerId) {
                return accountRepository
                                .findByCustomerId(cutomerId)
                                .map(AccountMapper::toDto);
        }

        @Override
        public Mono<AccountDetailDto> create(
                        Mono<AccountCreateDto> accountCreateDto) {
                return accountCreateDto
                                .filter(dto -> accountValidation.validateAccount(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.ACCOUNTVALIDATIONERROR)))
                                .flatMap(dto -> accountValidation.validateDbAccount(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.ACCOUNTDBVALIDATIONERROR)))
                                .map(AccountMapper::toEntity)
                                .flatMap(accountRepository::insert)
                                .map(AccountMapper::toDto);
        }

        @Override
        public Flux<AccountMovementDetailDto> getMovementList(
                        String accountId) {
                return accountMovementRepository
                                .findByAccountId(accountId)
                                .map(AccountMovementMapper::toDto);
        }

        @Override
        public Mono<AccountMovementDetailDto> createMovement(
                        Mono<AccountMovementCreateDto> accountMovementCreateDto) {
                return accountMovementCreateDto
                                .filter(dto -> accountValidation.validateAccountMovement(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.ERRORACCOUNTMOVEMENTVALIDATION)))
                                .map(AccountMovementMapper::toEntity)
                                .flatMap(accountMovementRepository::insert)
                                .flatMap(e -> updateAccount(e))
                                .map(AccountMovementMapper::toDto);
        }

        private Mono<AccountMovementEntity> updateAccount(
                        AccountMovementEntity accountMovementEntity) {
                return accountRepository
                                .findById(accountMovementEntity.getAccountId())
                                .flatMap(accountEntity -> {
                                        accountEntity.setAvailableAmount(accountEntity.getAvailableAmount()
                                                        + accountMovementEntity.getAmount() * (accountMovementEntity
                                                                        .getMovementType().equalsIgnoreCase(
                                                                                        AccountMovementTypeEnum.DEPOSIT
                                                                                                        .getDescription())
                                                                                                                        ? 1
                                                                                                                        : -1));
                                        return accountRepository.save(accountEntity).thenReturn(accountMovementEntity);
                                });
        }

}
