package com.nttdatabanking.productservice.util.mapper;

import com.nttdatabanking.productservice.infraestructure.entity.AccountMovementEntity;
import com.nttdatabanking.productservice.model.AccountMovementCreateDto;
import com.nttdatabanking.productservice.model.AccountMovementDetailDto;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase mapeador movimiento cuenta.
 */
public class AccountMovementMapper {

    /**
     * Metodo mapeador AccountMovementEntity a AccountMovementDetailDto.
     */
    public static AccountMovementDetailDto toDto(
            AccountMovementEntity accountMovementEntity) {
        AccountMovementDetailDto accountMovementDetailDto = new AccountMovementDetailDto();
        accountMovementDetailDto.setId(accountMovementEntity.get_id());
        accountMovementDetailDto.setAccountId(accountMovementEntity.getAccountId());
        accountMovementDetailDto.setAccountType(accountMovementEntity.getAccountType());
        accountMovementDetailDto.setDescription(accountMovementEntity.getDescription());
        accountMovementDetailDto.setMovementType(accountMovementEntity.getMovementType());
        accountMovementDetailDto.setAmount(accountMovementEntity.getAmount());
        accountMovementDetailDto.setMovementDate(
                OffsetDateTime.parse(accountMovementEntity.getMovementDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        return accountMovementDetailDto;
    }

    /**
     * Metodo mapeador AccountMovementCreateDto a AccountMovementEntity.
     */
    public static AccountMovementEntity toEntity(
            AccountMovementCreateDto accountMovementCreateDto) {
        AccountMovementEntity accountMovementEntity = new AccountMovementEntity();
        accountMovementEntity.setAccountId(accountMovementCreateDto.getAccountId());
        accountMovementEntity.setAccountType(accountMovementCreateDto.getAccountType().toUpperCase());
        accountMovementEntity.setDescription(accountMovementCreateDto.getDescription());
        accountMovementEntity.setMovementType(accountMovementCreateDto.getMovementType().toUpperCase());
        accountMovementEntity.setAmount(accountMovementCreateDto.getAmount());
        accountMovementEntity.setMovementDate(accountMovementCreateDto.getMovementDate().toString());
        return accountMovementEntity;
    }

}
