package com.nttdatabanking.productservice.util.mapper;

import com.nttdatabanking.productservice.infraestructure.entity.CreditEntity;
import com.nttdatabanking.productservice.model.CreditCreateDto;
import com.nttdatabanking.productservice.model.CreditDetailDto;
import org.springframework.stereotype.Component;

/**
 * Clase mapper credito.
 */
@Component
public class CreditMapper {

    /**
     * Metodo map CreditEntity a CreditDetailDto.
     */
    public static CreditDetailDto toDto(CreditEntity creditEntity) {
        CreditDetailDto creditDetailDto = new CreditDetailDto();
        creditDetailDto.setId(creditEntity.get_id());
        creditDetailDto.setCustomerId(creditEntity.getCustomerId());
        creditDetailDto.setCustomerType(creditEntity.getCustomerType());
        creditDetailDto.setCreditNumber(creditEntity.getCreditNumber());
        creditDetailDto.setCreditType(creditEntity.getCreditType());
        creditDetailDto.setAmount(creditEntity.getAmount());
        creditDetailDto.setAvailableAmount(creditEntity.getAvailableAmount());
        return creditDetailDto;
    }

    /**
     * Metodo map CreditCreateDto a CreditEntity.
     */
    public static CreditEntity toEntity(CreditCreateDto creditCreateDto) {
        CreditEntity creditEntity = new CreditEntity();
        creditEntity.setCustomerId(creditCreateDto.getCustomerId());
        creditEntity.setCustomerType(creditCreateDto.getCustomerType());
        creditEntity.setCreditNumber(creditCreateDto.getCreditNumber());
        creditEntity.setCreditType(creditCreateDto.getCreditType());
        creditEntity.setAmount(creditCreateDto.getAmount());
        creditEntity.setAvailableAmount(creditCreateDto.getAmount());
        return creditEntity;
    }

}
