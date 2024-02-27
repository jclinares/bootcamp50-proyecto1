package com.nttdatabanking.customerservice.util.mapper;

import org.springframework.stereotype.Component;

import com.nttdatabanking.customerservice.domain.dto.CustomerCreateDto;
import com.nttdatabanking.customerservice.domain.dto.CustomerDetailDto;
import com.nttdatabanking.customerservice.domain.dto.CustomerUpdateDto;
import com.nttdatabanking.customerservice.infraestructure.entity.CustomerEntity;

@Component
public class CustomerMapper {

    public static CustomerDetailDto toDto(CustomerEntity customerEntity) {
        CustomerDetailDto customerDetailDto = new CustomerDetailDto();
        customerDetailDto.setId(customerEntity.get_id());
        customerDetailDto.setName(customerEntity.getName());
        customerDetailDto.setLastname(customerEntity.getLastname());
        customerDetailDto.setDocumentNumber(customerEntity.getDocumentNumber());
        customerDetailDto.setEmail(customerEntity.getEmail());
        customerDetailDto.setCustomerType(customerEntity.getCustomerType());
        return customerDetailDto;
    }

    public static CustomerEntity toEntity(CustomerCreateDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastname(customerDto.getLastname());
        customerEntity.setDocumentNumber(customerDto.getDocumentNumber());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setCustomerType(customerDto.getCustomerType());
        return customerEntity;
    }

    public static CustomerEntity toEntity(CustomerUpdateDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.set_id(customerDto.getId());
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastname(customerDto.getLastname());
        customerEntity.setDocumentNumber(customerDto.getDocumentNumber());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setCustomerType(customerDto.getCustomerType());
        return customerEntity;
    }

}
