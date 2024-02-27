package com.nttdatabanking.productservice.util.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.nttdatabanking.productservice.domain.dto.AccountCreateDto;
import com.nttdatabanking.productservice.domain.dto.AccountDetailDto;
import com.nttdatabanking.productservice.infraestructure.entity.AccountCustomer;
import com.nttdatabanking.productservice.infraestructure.entity.AccountEntity;

@Component
public class AccountMapper {

    public static AccountDetailDto toDto(AccountEntity accountEntity) {
        AccountDetailDto accountDetailDto = new AccountDetailDto();
        accountDetailDto.setId(accountEntity.get_id());
        accountDetailDto.setAccountCustomerType(accountEntity.getAccountCustomerType());
        accountDetailDto.setAccountNumber(accountEntity.getAccountNumber());
        accountDetailDto.setAccountType(accountEntity.getAccountType());
        accountDetailDto.setAvailableAmount(accountEntity.getAvailableAmount());
        accountDetailDto.setCommission(accountEntity.getCommission());
        accountDetailDto.setMovementLimits(accountEntity.getMovementLimits());
        accountDetailDto.setDayMovement(accountEntity.getDayMovement());
        return accountDetailDto;
    }

    public static AccountEntity toEntity(AccountCreateDto accountCreateDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountCustomerType(accountCreateDto.getAccountCustomerType());
        accountEntity.setAccountCustomer(toEntity(accountCreateDto.getAccountCustomer()));
        accountEntity.setAccountNumber(accountCreateDto.getAccountNumber());
        accountEntity.setAccountType(accountCreateDto.getAccountType());
        accountEntity.setAvailableAmount(accountCreateDto.getAvailableAmount());
        accountEntity.setCommission(accountCreateDto.getCommission());
        accountEntity.setMovementLimits(accountCreateDto.getMovementLimits());
        accountEntity.setDayMovement(accountCreateDto.getDayMovement());
        return accountEntity;
    }

    private static List<AccountCustomer> toEntity(
            List<com.nttdatabanking.productservice.domain.dto.@Valid AccountCustomer> accountCustomerDto) {
        List<AccountCustomer> accountCustomerList = new ArrayList<>();
        for (com.nttdatabanking.productservice.domain.dto.@Valid AccountCustomer accountCustomer : accountCustomerDto) {
            accountCustomerList.add(toEntity(accountCustomer));
        }
        return accountCustomerList;
    }

    private static AccountCustomer toEntity(
            com.nttdatabanking.productservice.domain.dto.@Valid AccountCustomer accountCustomerDto) {
        AccountCustomer accountCustomer = new AccountCustomer();
        accountCustomer.setCustomerId(accountCustomerDto.getCustomerId());
        accountCustomer.setBusinessCustomerType(accountCustomerDto.getBusinessCustomerType());
        return accountCustomer;
    }

}
