package com.nttdatabanking.customerservice.util.mapper;

import com.nttdatabanking.customerservice.infraestructure.entity.CustomerEntity;
import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerDetailDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import org.springframework.stereotype.Component;

/**
 * Clase mapper cliente.
 */
@Component
public class CustomerMapper {

    private CustomerMapper() {
    }

    /**
     * Metodo map CustomerEntity a CustomerDetailDto.
     */
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

    /**
     * Metodo map CustomerCreateDto a CustomerEntity.
     */
    public static CustomerEntity toEntity(CustomerCreateDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastname(customerDto.getLastname());
        customerEntity.setDocumentNumber(customerDto.getDocumentNumber());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setCustomerType(customerDto.getCustomerType().toUpperCase());
        return customerEntity;
    }

    /**
     * Metodo map CustomerUpdateDto a CustomerEntity.
     */
    public static CustomerEntity toEntity(CustomerUpdateDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.set_id(customerDto.getId());
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastname(customerDto.getLastname());
        customerEntity.setDocumentNumber(customerDto.getDocumentNumber());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setCustomerType(customerDto.getCustomerType().toUpperCase());
        return customerEntity;
    }

}
