package com.nttdatabanking.productservice.util.mapper;

import com.nttdatabanking.productservice.infraestructure.entity.CreditMovementEntity;
import com.nttdatabanking.productservice.model.CreditMovementCreateDto;
import com.nttdatabanking.productservice.model.CreditMovementDetailDto;

/**
 * Clase mapeador movimiento credito.
 */
public class CreditMovementMapper {

    /**
     * Metodo mapeador CreditMovementEntity a CreditMovementDetailDto.
     */
    public static CreditMovementDetailDto toDto(CreditMovementEntity creditMovementEntity) {
        CreditMovementDetailDto creditMovementDetailDto = new CreditMovementDetailDto();
        creditMovementDetailDto.setId(creditMovementEntity.get_id());
        creditMovementDetailDto.setDescription(creditMovementEntity.getDescription());
        creditMovementDetailDto.setMovementType(creditMovementEntity.getMovementType());
        creditMovementDetailDto.setAmount(creditMovementEntity.getAmount());
        return creditMovementDetailDto;
    }

    /**
     * Metodo mapeador CreditMovementCreateDto a CreditMovementEntity.
     */
    public static CreditMovementEntity toEntity(CreditMovementCreateDto creditMovementCreateDto) {
        CreditMovementEntity creditMovementEntity = new CreditMovementEntity();
        creditMovementEntity.setCreditId(creditMovementCreateDto.getCreditId());
        creditMovementEntity.setDescription(creditMovementCreateDto.getDescription());
        creditMovementEntity.setMovementType(creditMovementCreateDto.getMovementType().toUpperCase());
        creditMovementEntity.setAmount(creditMovementCreateDto.getAmount());
        return creditMovementEntity;
    }

}
