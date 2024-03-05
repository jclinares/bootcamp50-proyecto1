package com.nttdatabanking.productservice.util.validation;

import com.nttdatabanking.productservice.infraestructure.repository.CreditRepository;
import com.nttdatabanking.productservice.model.CreditCreateDto;
import com.nttdatabanking.productservice.util.enumeration.CostumerTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.CreditTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.UtilEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Clase validador credito.
 */
@Service
public class CreditValidator {

    @Autowired
    private CreditRepository creditRepository;

    /**
     * Metodo validador credito.
     */
    public Boolean validateCredit(CreditCreateDto dto) {
        return validateGeneralCreditt(dto)
                && validatePersonalCredit(dto)
                && validatePersonalVipCredit(dto)
                && validateBusinessCredit(dto)
                && validateBusinessMypeCredit(dto);
    }

    /**
     * Metodo validador db credito.
     */
    public Mono<CreditCreateDto> validateDbCredit(CreditCreateDto dto) {
        String customerType = dto.getCustomerType().toUpperCase();
        String creditType = dto.getCreditType().toUpperCase();
        if (customerType.equals(CostumerTypeEnum.PERSONAL.getDescription())) {
            return creditRepository.findByCustomerId(dto.getCustomerId()).collectList()
                    .flatMap(result -> {
                        Long personalCredits = result.stream().filter(
                                credit -> credit.getCreditType().equals(CreditTypeEnum.PERSONAL.getDescription()))
                                .count();
                        if (creditType.equals(CreditTypeEnum.PERSONAL.getDescription())
                                && personalCredits == 0) {
                            return Mono.just(dto);
                        }
                        if (creditType.equals(CreditTypeEnum.CREDITCARD.getDescription())) {
                            return Mono.just(dto);
                        }
                        return Mono.empty();
                    });
        }
        if (customerType.equals(CostumerTypeEnum.PERSONALVIP.getDescription())) {
            return Mono.just(dto);
        }
        if (customerType.equals(CostumerTypeEnum.BUSINESS.getDescription())) {
            return Mono.just(dto);
        }
        if (customerType.equals(CostumerTypeEnum.BUSINESSMYPE.getDescription())) {
            return Mono.just(dto);
        }
        return Mono.empty();
    }

    private Boolean validateGeneralCreditt(CreditCreateDto dto) {
        return StringUtils.isNotBlank(dto.getCustomerId())
                && StringUtils.isNotBlank(dto.getCustomerType())
                && UtilEnum.getByDescription(CostumerTypeEnum.class, dto.getCustomerType()) != null
                && StringUtils.isNotBlank(dto.getCreditNumber())
                && StringUtils.isNotBlank(dto.getCreditType())
                && UtilEnum.getByDescription(CreditTypeEnum.class, dto.getCreditType()) != null
                && dto.getAmount() != null
                && dto.getAmount() >= 0;
    }

    private Boolean validatePersonalCredit(CreditCreateDto dto) {
        String creditType = dto.getCreditType().toUpperCase();
        return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.PERSONAL.getDescription())
                || (creditType.equals(CreditTypeEnum.PERSONAL.getDescription())
                        || creditType.equals(CreditTypeEnum.CREDITCARD.getDescription()));
    }

    private Boolean validatePersonalVipCredit(CreditCreateDto dto) {
        String creditType = dto.getCreditType().toUpperCase();
        return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.PERSONALVIP.getDescription())
                || (creditType.equals(CreditTypeEnum.PERSONAL.getDescription())
                        || creditType.equals(CreditTypeEnum.CREDITCARD.getDescription()));
    }

    private Boolean validateBusinessCredit(CreditCreateDto dto) {
        String creditType = dto.getCreditType().toUpperCase();
        return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.BUSINESS.getDescription())
                || (creditType.equals(CreditTypeEnum.BUSINESS.getDescription())
                        || creditType.equals(CreditTypeEnum.CREDITCARD.getDescription()));
    }

    private Boolean validateBusinessMypeCredit(CreditCreateDto dto) {
        String creditType = dto.getCreditType().toUpperCase();
        return !dto.getCustomerType().equalsIgnoreCase(CostumerTypeEnum.BUSINESSMYPE.getDescription())
                || (creditType.equals(CreditTypeEnum.BUSINESS.getDescription())
                        || creditType.equals(CreditTypeEnum.CREDITCARD.getDescription()));
    }

}
