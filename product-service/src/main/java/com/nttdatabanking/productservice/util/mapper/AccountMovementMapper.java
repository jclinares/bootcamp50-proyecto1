package com.nttdatabanking.productservice.util.mapper;

import com.nttdatabanking.productservice.domain.dto.AccountMovementCreateDto;
import com.nttdatabanking.productservice.domain.dto.AccountMovementDetailDto;
import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;

public class AccountMovementMapper {

    public static AccountMovementDetailDto toDto(AccountMovementEntity accountMovementEntity) {
        AccountMovementDetailDto accountMovementDetailDto = new AccountMovementDetailDto();
        accountMovementDetailDto.setId(accountMovementEntity.get_id());
        accountMovementDetailDto.setDescription(accountMovementEntity.getDescription());
        accountMovementDetailDto.setMovementType(accountMovementEntity.getMovementType());
        accountMovementDetailDto.setAmount(accountMovementEntity.getAmount());
        return accountMovementDetailDto;
    }

    public static AccountMovementEntity toEntity(AccountMovementCreateDto accountMovementCreateDto) {
        AccountMovementEntity accountMovementEntity = new AccountMovementEntity();
        accountMovementEntity.setAccountId(accountMovementCreateDto.getAccountId());
        accountMovementEntity.setDescription(accountMovementCreateDto.getDescription());
        accountMovementEntity.setMovementType(accountMovementCreateDto.getMovementType());
        accountMovementEntity.setAmount(accountMovementCreateDto.getAmount());
        return accountMovementEntity;
    }

}
