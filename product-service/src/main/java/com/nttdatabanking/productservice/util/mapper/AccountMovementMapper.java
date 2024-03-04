package com.nttdatabanking.productservice.util.mapper;

import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;
import com.nttdatabanking.productservice.model.AccountMovementCreateDto;
import com.nttdatabanking.productservice.model.AccountMovementDetailDto;

/**
 * Clase mapper movimiento cuenta.
 */
public class AccountMovementMapper {

    /**
     * Metodo map AccountMovementEntity a AccountMovementDetailDto.
     */
    public static AccountMovementDetailDto toDto(
            AccountMovementEntity accountMovementEntity) {
        AccountMovementDetailDto accountMovementDetailDto = new AccountMovementDetailDto();
        accountMovementDetailDto.setId(accountMovementEntity.get_id());
        accountMovementDetailDto.setDescription(accountMovementEntity.getDescription());
        accountMovementDetailDto.setMovementType(accountMovementEntity.getMovementType());
        accountMovementDetailDto.setAmount(accountMovementEntity.getAmount());
        return accountMovementDetailDto;
    }

    /**
     * Metodo map AccountMovementCreateDto a AccountMovementEntity.
     */
    public static AccountMovementEntity toEntity(
            AccountMovementCreateDto accountMovementCreateDto) {
        AccountMovementEntity accountMovementEntity = new AccountMovementEntity();
        accountMovementEntity.setAccountId(accountMovementCreateDto.getAccountId());
        accountMovementEntity.setDescription(accountMovementCreateDto.getDescription());
        accountMovementEntity.setMovementType(accountMovementCreateDto.getMovementType());
        accountMovementEntity.setAmount(accountMovementCreateDto.getAmount());
        return accountMovementEntity;
    }

}
