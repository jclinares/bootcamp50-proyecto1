package com.nttdatabanking.productservice.util.validation;

import com.nttdatabanking.productservice.infraestructure.entity.AccountEntity;
import com.nttdatabanking.productservice.infraestructure.repository.AccountMovementRepository;
import com.nttdatabanking.productservice.infraestructure.repository.AccountRepository;
import com.nttdatabanking.productservice.model.AccountMovementCreateDto;
import com.nttdatabanking.productservice.util.Constants;
import com.nttdatabanking.productservice.util.enumeration.AccountMovementTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.AccountTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.CreditMovementTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.UtilEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Clase validador movimiento cuenta.
 */
@Service
public class AccountMovementValidator {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMovementRepository accountMovementRepository;

    /**
     * Metodo validador movimiento cuenta.
     */
    public Boolean validateAccountMovement(AccountMovementCreateDto dto) {
        return validateGeneralAccountMovement(dto)
                && validateFixedDepositAccountMovement(dto);
    }

    /**
     * Metodo validador db cuenta.
     */
    public Mono<AccountMovementCreateDto> validateDbAccountMovement(AccountMovementCreateDto dto) {
        Double movementAmount = dto.getAmount();
        Double movementSign = dto.getMovementType().equals(AccountMovementTypeEnum.DEPOSIT.getDescription())
                ? 1.0
                : -1.0;
        String movementMonth = dto.getMovementDate().toString().substring(0, 6);
        return Mono.zip(accountRepository.findById(dto.getAccountId()),
                accountMovementRepository.countByAccountId(dto.getAccountId()),
                accountMovementRepository.countByAccountIdAndMovementMonth(dto.getAccountId(), movementMonth))
                .flatMap(
                        tuple -> {
                            AccountEntity accountEntity = tuple.getT1();
                            Long countMovements = tuple.getT2();
                            Long countMonthlyMovements = tuple.getT3();
                            Boolean freeMovement = countMovements < Constants.ACCOUNTMAXIMUMFREEMOVEMENTS;
                            Double accountAmount = accountEntity.getAvailableAmount() + (movementAmount * movementSign)
                                    - (freeMovement ? 0 : Constants.ACCOUNTCOMMISSIONNOTFREEMOVEMENTS);
                            if (accountEntity.getAccountType().equals(AccountTypeEnum.SAVINGS.getDescription())) {
                                if (accountAmount > 0
                                        && countMonthlyMovements <= Constants.SAVINGSACCOUNTMAXIMUMMONTHLYMOVEMENTS) {
                                    return Mono.just(dto);
                                }
                                return Mono.empty();
                            }
                            if (accountEntity.getAccountType().equals(AccountTypeEnum.CURRENT.getDescription())) {
                                if (accountAmount > 0) {
                                    return Mono.just(dto);
                                }
                                return Mono.empty();
                            }
                            if (accountEntity.getAccountType().equals(AccountTypeEnum.FIXEDDEPOSIT.getDescription())) {
                                if (accountAmount > 0 && countMonthlyMovements == 0) {
                                    return Mono.just(dto);
                                }
                                return Mono.empty();
                            }
                            return Mono.empty();

                        });
    }

    private Boolean validateGeneralAccountMovement(AccountMovementCreateDto dto) {
        return StringUtils.isNotBlank(dto.getAccountId())
                && StringUtils.isNotBlank(dto.getDescription())
                && StringUtils.isNotBlank(dto.getMovementType())
                && UtilEnum.getByDescription(CreditMovementTypeEnum.class, dto.getMovementType()) != null
                && dto.getAmount() != null
                && dto.getAmount() >= 0
                && dto.getMovementDate() != null;
    }

    private Boolean validateFixedDepositAccountMovement(AccountMovementCreateDto dto) {
        return !dto.getAccountType().equalsIgnoreCase(AccountTypeEnum.FIXEDDEPOSIT.getDescription())
                || (dto.getMovementDate().getDayOfMonth() == Constants.FIXEDDEPOSITACCOUNTMOVEMENTDAY);
    }

}
