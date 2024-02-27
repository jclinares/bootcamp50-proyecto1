package com.nttdatabanking.productservice.util.mapper;

import com.nttdatabanking.productservice.domain.dto.CreditMovementCreateDto;
import com.nttdatabanking.productservice.domain.dto.CreditMovementDetailDto;
import com.nttdatabanking.productservice.infraestructure.entity.CreditMovementEntity;

public class CreditMovementMapper {

    public static CreditMovementDetailDto toDto(CreditMovementEntity creditMovementEntity) {
        CreditMovementDetailDto creditMovementDetailDto = new CreditMovementDetailDto();
        creditMovementDetailDto.setId(creditMovementEntity.get_id());
        creditMovementDetailDto.setDescription(creditMovementEntity.getDescription());
        creditMovementDetailDto.setMovementType(creditMovementEntity.getMovementType());
        creditMovementDetailDto.setAmount(creditMovementEntity.getAmount());
        return creditMovementDetailDto;
    }

    public static CreditMovementEntity toEntity(CreditMovementCreateDto creditMovementCreateDto) {
        CreditMovementEntity creditMovementEntity = new CreditMovementEntity();
        creditMovementEntity.setCreditId(creditMovementCreateDto.getCreditId());
        creditMovementEntity.setDescription(creditMovementCreateDto.getDescription());
        creditMovementEntity.setMovementType(creditMovementCreateDto.getMovementType());
        creditMovementEntity.setAmount(creditMovementCreateDto.getAmount());
        return creditMovementEntity;
    }

}
