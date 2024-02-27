package com.nttdatabanking.productservice.util.mapper;

import org.springframework.stereotype.Component;

import com.nttdatabanking.productservice.domain.dto.CreditCreateDto;
import com.nttdatabanking.productservice.domain.dto.CreditDetailDto;
import com.nttdatabanking.productservice.infraestructure.entity.CreditEntity;

@Component
public class CreditMapper {

    public static CreditDetailDto toDto(CreditEntity creditEntity) {
        CreditDetailDto creditDetailDto = new CreditDetailDto();
        creditDetailDto.setId(creditEntity.get_id());
        creditDetailDto.setCreditNumber(creditEntity.getCreditNumber());
        creditDetailDto.setCreditType(creditEntity.getCreditType());
        creditDetailDto.setLimitAmount(creditEntity.getLimitAmount());
        creditDetailDto.setAvailableAmount(creditEntity.getAvailableAmount());
        return creditDetailDto;
    }

    public static CreditEntity toEntity(CreditCreateDto creditCreateDto) {
        CreditEntity creditEntity = new CreditEntity();
        creditEntity.setCustomerId(creditCreateDto.getCustomerId());
        creditEntity.setCreditNumber(creditCreateDto.getCreditNumber());
        creditEntity.setCreditType(creditCreateDto.getCreditType());
        creditEntity.setLimitAmount(creditCreateDto.getLimitAmount());
        creditEntity.setAvailableAmount(creditCreateDto.getAvailableAmount());
        return creditEntity;
    }

}
