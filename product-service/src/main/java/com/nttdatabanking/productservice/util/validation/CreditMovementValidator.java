package com.nttdatabanking.productservice.util.validation;

import com.nttdatabanking.productservice.model.CreditMovementCreateDto;
import com.nttdatabanking.productservice.util.enumeration.CreditMovementTypeEnum;
import com.nttdatabanking.productservice.util.enumeration.UtilEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Clase validador movimiento credito.
 */
@Service

public class CreditMovementValidator {

    /**
     * Metodo validacion movimiento credito.
     */
    public Boolean validateCreditMovement(CreditMovementCreateDto dto) {
        return StringUtils.isNotBlank(dto.getCreditId())
                && StringUtils.isNotBlank(dto.getDescription())
                && StringUtils.isNotBlank(dto.getMovementType())
                && UtilEnum.getByDescription(CreditMovementTypeEnum.class, dto.getMovementType()) != null
                && dto.getAmount() != null
                && dto.getAmount() >= 0;
    }

}
