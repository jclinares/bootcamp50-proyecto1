package com.nttdatabanking.productservice.util.validation;

import com.nttdatabanking.productservice.infraestructure.repository.AccountRepository;
import com.nttdatabanking.productservice.infraestructure.repository.CreditRepository;
import com.nttdatabanking.productservice.model.AccountCreateDto;
import com.nttdatabanking.productservice.model.AccountMovementCreateDto;
import com.nttdatabanking.productservice.model.CustomerDto;
import com.nttdatabanking.productservice.util.enumeration.AccountMovementTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.AccountTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.BusinessCostumerTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.CostumerTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.CreditTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.UtilEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Clase validacion cuenta.
 */
@Service
public class AccountValidation {

        @Autowired
        private AccountRepository accountRepository;

        @Autowired
        private CreditRepository creditRepository;

        /**
         * Metodo validacion cuenta.
         */
        public Boolean validateAccount(AccountCreateDto dto) {
                return validateGeneralAccount(dto)
                                && validatePersonalAccount(dto)
                                && validatePersonalVipAccount(dto)
                                && validateBusinessAccount(dto)
                                && validateBusinessMypeAccount(dto);
        }

        /**
         * Metodo validacion db cuenta.
         */
        public Mono<AccountCreateDto> validateDbAccount(AccountCreateDto dto) {
                String customerType = dto.getCustomerType().toUpperCase();
                String accountType = dto.getAccountType().toUpperCase();
                if (customerType.equals(CostumerTypeEnum.PERSONAL.getDescription())) {
                        return accountRepository.findByCustomerId(dto.getCustomerList().get(0).getCustomerId())
                                        .collectList()
                                        .flatMap(result -> {
                                                Long savingsAccounts = result.stream()
                                                                .filter(account -> account.getAccountType()
                                                                                .equals(AccountTypeEnum.SAVINGS
                                                                                                .getDescription()))
                                                                .count();
                                                Long currentAccounts = result.stream()
                                                                .filter(account -> account.getAccountType()
                                                                                .equals(AccountTypeEnum.CURRENT
                                                                                                .getDescription()))
                                                                .count();
                                                if (accountType.equals(AccountTypeEnum.SAVINGS.getDescription())
                                                                && savingsAccounts == 0) {
                                                        return Mono.just(dto);
                                                }
                                                if (accountType.equals(AccountTypeEnum.CURRENT.getDescription())
                                                                && currentAccounts == 0) {
                                                        return Mono.just(dto);
                                                }
                                                if (accountType.equals(AccountTypeEnum.FIXEDDEPOSIT.getDescription())) {
                                                        return Mono.just(dto);
                                                }
                                                return Mono.empty();
                                        });
                }
                if (customerType.equals(CostumerTypeEnum.PERSONALVIP.getDescription())) {
                        return creditRepository.findByCustomerId(dto.getCustomerList().get(0).getCustomerId())
                                        .collectList()
                                        .flatMap(result -> {
                                                Long creditCardCredits = result.stream()
                                                                .filter(credit -> credit.getCreditType()
                                                                                .equals(CreditTypeEnum.CREDITCARD
                                                                                                .getDescription()))
                                                                .count();
                                                if (accountType.equals(AccountTypeEnum.SAVINGS.getDescription())
                                                                && creditCardCredits > 0) {
                                                        return Mono.just(dto);
                                                }
                                                return Mono.empty();
                                        });
                }
                if (customerType.equals(CostumerTypeEnum.BUSINESS.getDescription())) {
                        return Mono.just(dto);
                }
                if (customerType.equals(CostumerTypeEnum.BUSINESSMYPE.getDescription())) {
                        return creditRepository.findByCustomerId(dto.getCustomerList().get(0).getCustomerId())
                                        .collectList()
                                        .flatMap(result -> {
                                                Long creditCardCredits = result
                                                                .stream()
                                                                .filter(credit -> credit.getCreditType()
                                                                                .equals(CreditTypeEnum.CREDITCARD
                                                                                                .getDescription()))
                                                                .count();
                                                if (accountType.equals(AccountTypeEnum.CURRENT.getDescription())
                                                                && creditCardCredits > 0) {
                                                        return Mono.just(dto);
                                                }
                                                return Mono.empty();
                                        });
                }
                return Mono.empty();
        }

        /**
         * Metodo validacion movimiento cuenta.
         */
        public Boolean validateAccountMovement(AccountMovementCreateDto dto) {
                return UtilEnum.getByDescription(AccountMovementTypeEnum.class, dto.getMovementType()) != null;
        }

        private Boolean validateGeneralAccount(AccountCreateDto dto) {
                return StringUtils.isNotBlank(dto.getCustomerType())
                                && UtilEnum.getByDescription(CostumerTypeEnum.class, dto.getCustomerType()) != null
                                && dto.getCustomerList() != null
                                && dto.getCustomerList().size() > 0
                                && StringUtils.isNotBlank(dto.getAccountNumber())
                                && StringUtils.isNotBlank(dto.getAccountType())
                                && UtilEnum.getByDescription(AccountTypeEnum.class, dto.getAccountType()) != null
                                && dto.getAvailableAmount() != null
                                && dto.getAvailableAmount() >= 0;
        }

        private Boolean validatePersonalAccount(AccountCreateDto dto) {
                return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.PERSONAL.getDescription())
                                || (dto.getCustomerList().size() == 1 && dto.getCustomerList().stream()
                                                .allMatch(AccountValidation::validatePersonalCustomer));
        }

        private Boolean validatePersonalVipAccount(AccountCreateDto dto) {
                return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.PERSONALVIP.getDescription())
                                || (dto.getCustomerList().size() == 1 && dto.getCustomerList().stream()
                                                .allMatch(AccountValidation::validatePersonalCustomer)
                                                && dto.getAccountType().equalsIgnoreCase(
                                                                AccountTypeEnum.SAVINGS.getDescription()));
        }

        private Boolean validateBusinessAccount(AccountCreateDto dto) {
                return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.BUSINESS.getDescription())
                                || (dto.getCustomerList().size() >= 1
                                                && dto.getCustomerList().stream()
                                                                .allMatch(AccountValidation::validateBusinessCustomer)
                                                && dto.getAccountType().equalsIgnoreCase(
                                                                AccountTypeEnum.CURRENT.getDescription()));
        }

        private Boolean validateBusinessMypeAccount(AccountCreateDto dto) {
                return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.BUSINESSMYPE.getDescription())
                                || (dto.getCustomerList().size() >= 1
                                                && dto.getCustomerList().stream()
                                                                .allMatch(AccountValidation::validateBusinessCustomer)
                                                && dto.getAccountType().equalsIgnoreCase(
                                                                AccountTypeEnum.CURRENT.getDescription()));
        }

        private static Boolean validatePersonalCustomer(CustomerDto dto) {
                return StringUtils.isNotBlank(dto.getCustomerId());
        }

        private static Boolean validateBusinessCustomer(CustomerDto dto) {
                return StringUtils.isNotBlank(dto.getCustomerId())
                                && UtilEnum.getByDescription(BusinessCostumerTypeEnum.class,
                                                dto.getBusinessCustomerType()) != null;
        }

}
