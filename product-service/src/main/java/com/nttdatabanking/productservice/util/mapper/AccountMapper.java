package com.nttdatabanking.productservice.util.mapper;

import com.nttdatabanking.productservice.infraestructure.entity.AccountEntity;
import com.nttdatabanking.productservice.infraestructure.entity.CustomerEntity;
import com.nttdatabanking.productservice.model.AccountCreateDto;
import com.nttdatabanking.productservice.model.AccountDetailDto;
import com.nttdatabanking.productservice.model.CustomerDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Clase mapper cuenta.
 */
@Component
public class AccountMapper {

    /**
     * Metodo map AccountEntity a AccountDetailDto.
     */
    public static AccountDetailDto toDto(
            AccountEntity accountEntity) {
        AccountDetailDto accountDetailDto = new AccountDetailDto();
        accountDetailDto.setId(accountEntity.get_id());
        accountDetailDto.setCustomerType(accountEntity.getCustomerType());
        accountDetailDto.setAccountNumber(accountEntity.getAccountNumber());
        accountDetailDto.setAccountType(accountEntity.getAccountType());
        accountDetailDto.setAvailableAmount(accountEntity.getAvailableAmount());
        return accountDetailDto;
    }

    /**
     * Metodo map AccountCreateDto a AccountEntity.
     */
    public static AccountEntity toEntity(AccountCreateDto accountCreateDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCustomerType(accountCreateDto.getCustomerType());
        accountEntity.setCustomerList(toEntity(accountCreateDto.getCustomerList()));
        accountEntity.setAccountNumber(accountCreateDto.getAccountNumber());
        accountEntity.setAccountType(accountCreateDto.getAccountType());
        accountEntity.setAvailableAmount(accountCreateDto.getAvailableAmount());
        return accountEntity;
    }

    /**
     * Metodo map ListAccountCustomerDto a ListAccountCustomerEntity.
     */
    private static List<CustomerEntity> toEntity(List<CustomerDto> customerDtoList) {
        List<CustomerEntity> accountCustomerList = new ArrayList<>();
        for (CustomerDto customer : customerDtoList) {
            accountCustomerList.add(toEntity(customer));
        }
        return accountCustomerList;
    }

    /**
     * Metodo map AccountCustomerDto a AccountCustomerEntity.
     */
    private static CustomerEntity toEntity(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerDto.getCustomerId());
        customerEntity.setBusinessCustomerType(customerDto.getBusinessCustomerType());
        return customerEntity;
    }

}
