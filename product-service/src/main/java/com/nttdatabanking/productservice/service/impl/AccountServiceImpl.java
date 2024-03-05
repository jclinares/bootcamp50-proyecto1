package com.nttdatabanking.productservice.service.impl;

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
import com.nttdatabanking.productservice.util.validation.AccountMovementValidator;
import com.nttdatabanking.productservice.util.validation.AccountValidator;
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
        private AccountValidator accountValidator;

        @Autowired
        private AccountMovementValidator accountMovementValidator;

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
                                .filter(dto -> accountValidator.validateAccount(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.ACCOUNTVALIDATIONERROR)))
                                .flatMap(dto -> accountValidator.validateDbAccount(dto))
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
                                .filter(dto -> accountMovementValidator.validateAccountMovement(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.ACCOUNTMOVEMENTVALIDATIONERROR)))
                                .flatMap(dto -> accountMovementValidator.validateDbAccountMovement(dto))
                                .switchIfEmpty(Mono.error(new Error(Messages.ACCOUNTMOVEMENTDBVALIDATIONERROR)))
                                .map(AccountMovementMapper::toEntity)
                                .flatMap(accountMovementRepository::insert)
                                .flatMap(accountMovementEntity -> accountRepository
                                                .findById(accountMovementEntity.getAccountId())
                                                .flatMap(accountEntity -> {
                                                        Double accountAmount = accountEntity.getAvailableAmount();
                                                        Double movementAmount = accountMovementEntity.getAmount();
                                                        Double movementSign = accountMovementEntity.getMovementType()
                                                                        .equals(AccountMovementTypeEnum.DEPOSIT
                                                                                        .getDescription()) ? 1.0 : -1.0;
                                                        accountAmount = accountAmount + movementAmount * movementSign;
                                                        accountEntity.setAvailableAmount(accountAmount);
                                                        return accountRepository.save(accountEntity)
                                                                        .thenReturn(accountMovementEntity)
                                                                        .map(AccountMovementMapper::toDto);
                                                }));
        }

}
