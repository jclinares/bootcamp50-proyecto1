package com.nttdatabanking.productservice.domain.impl;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdatabanking.productservice.domain.AccountService;
import com.nttdatabanking.productservice.domain.dto.AccountCreateDto;
import com.nttdatabanking.productservice.domain.dto.AccountCustomer;
import com.nttdatabanking.productservice.domain.dto.AccountDetailDto;
import com.nttdatabanking.productservice.domain.dto.AccountMovementCreateDto;
import com.nttdatabanking.productservice.domain.dto.AccountMovementDetailDto;
import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;
import com.nttdatabanking.productservice.infraestructure.repository.AccountMovementRepository;
import com.nttdatabanking.productservice.infraestructure.repository.AccountRepository;
import com.nttdatabanking.productservice.util.Constants;
import com.nttdatabanking.productservice.util.Messages;
import com.nttdatabanking.productservice.util.mapper.AccountMapper;
import com.nttdatabanking.productservice.util.mapper.AccountMovementMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

        @Autowired
        private AccountRepository accountRepository;

        @Autowired
        private AccountMovementRepository accountMovementRepository;

        @Override
        public Flux<AccountDetailDto> getList(String cutomerId) {
                return accountRepository.findByCustomerId(cutomerId)
                                .map(AccountMapper::toDto);
        }

        @Override
        public Mono<AccountDetailDto> create(Mono<AccountCreateDto> accountCreateDto) {
                return accountCreateDto
                                .flatMap(AccountServiceImpl::validate)
                                .switchIfEmpty(Mono.error(new Error(Messages.ERROR_ACCOUNT_VALIDATION)))
                                .map(AccountMapper::toEntity)
                                .flatMap(accountRepository::insert)
                                .map(AccountMapper::toDto);
        }

        @Override
        public Flux<AccountMovementDetailDto> getMovementList(String accountId) {
                return accountMovementRepository.findByAccountId(accountId)
                                .map(AccountMovementMapper::toDto);
        }

        @Override
        public Mono<AccountMovementDetailDto> createMovement(Mono<AccountMovementCreateDto> accountMovementCreateDto) {
                return accountMovementCreateDto
                                .flatMap(AccountServiceImpl::validate)
                                .switchIfEmpty(Mono.error(new Error(Messages.ERROR_ACCOUNTMOVEMENT_VALIDATION)))
                                .map(AccountMovementMapper::toEntity)
                                .flatMap(accountMovementRepository::insert)
                                .flatMap(e -> updateAccount(e))
                                .map(AccountMovementMapper::toDto);
        }

        private Mono<AccountMovementEntity> updateAccount(AccountMovementEntity accountMovementEntity) {
                return accountRepository.findById(accountMovementEntity.getAccountId())
                                .flatMap(accountEntity -> {
                                        accountEntity.setAvailableAmount(accountEntity.getAvailableAmount()
                                                        + accountMovementEntity.getAmount() * (accountMovementEntity
                                                                        .getMovementType().equalsIgnoreCase(
                                                                                        Constants.ACCOUNT_MOVEMENT_DEPOSIT)
                                                                                                        ? 1
                                                                                                        : -1));
                                        return accountRepository.save(accountEntity).thenReturn(accountMovementEntity);
                                });
        }

        private static Mono<AccountCreateDto> validate(AccountCreateDto accountCreateDto) {
                return Mono.just(accountCreateDto)
                                .filter(dto -> dto.getAccountCustomer() != null
                                                && dto.getAccountNumber() != null
                                                && dto.getAccountType() != null
                                                && dto.getAvailableAmount() != null)
                                .filter(dto -> (dto.getAccountCustomerType()
                                                .equalsIgnoreCase(Constants.CUSTOMER_PERSONAL)
                                                && dto.getAccountCustomer().size() == 1
                                                && dto.getAccountCustomer().stream()
                                                                .allMatch(validAccountCustomerPersonal)
                                                && (dto.getAccountType().equalsIgnoreCase(Constants.ACCOUNT_SAVINGS)
                                                                || dto.getAccountType().equalsIgnoreCase(
                                                                                Constants.ACCOUNT_CURRENT)
                                                                || dto.getAccountType().equalsIgnoreCase(
                                                                                Constants.ACCOUNT_FIXEDDEPOSIT)))
                                                ||
                                                (dto.getAccountCustomerType()
                                                                .equalsIgnoreCase(Constants.CUSTOMER_BUSINESS)
                                                                && dto.getAccountCustomer().size() >= 1
                                                                && dto.getAccountCustomer().stream()
                                                                                .allMatch(validAccountCustomerBusiness)
                                                                && dto.getAccountType().equalsIgnoreCase(
                                                                                Constants.ACCOUNT_CURRENT)));
        }

        private static Predicate<AccountCustomer> validAccountCustomerPersonal = dto -> dto.getCustomerId() != null;

        private static Predicate<AccountCustomer> validAccountCustomerBusiness = dto -> dto.getCustomerId() != null
                        && (dto.getBusinessCustomerType().equalsIgnoreCase(Constants.CUSTOMER_BUSINESS_HEADLINE)
                                        || dto.getBusinessCustomerType()
                                                        .equalsIgnoreCase(Constants.CUSTOMER_BUSINESS_SIGNATORY));

        private static Mono<AccountMovementCreateDto> validate(AccountMovementCreateDto accountMovementCreateDto) {
                return Mono.just(accountMovementCreateDto).filter(dto -> dto.getMovementType()
                                .equalsIgnoreCase(Constants.ACCOUNT_MOVEMENT_DEPOSIT)
                                || dto.getMovementType().equalsIgnoreCase(Constants.ACCOUNT_MOVEMENT_WITHDRAWAL));
        }

}
