package com.nttdatabanking.customerservice.util.validation;

import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import com.nttdatabanking.customerservice.util.enumeration.CostumerTypeEnum;
import com.nttdatabanking.customerservice.util.enumeration.UtilEnum;
import org.springframework.stereotype.Component;

/**
 * Clase validacion cliente.
 */
@Component
public class CustomerValidation {

    /**
     * Metodo validacion creacion cliente.
     */
    public static Boolean validateCustomer(CustomerCreateDto customerCreateDto) {
        return customerCreateDto.getName() != null
                && customerCreateDto.getLastname() != null
                && customerCreateDto.getDocumentNumber() != null
                && customerCreateDto.getEmail() != null
                && customerCreateDto.getCustomerType() != null
                && UtilEnum.getByDescription(CostumerTypeEnum.class,
                        customerCreateDto.getCustomerType()) != null;
    }

    /**
     * Metodo validacion actualizacion cliente.
     */
    public static Boolean validateCustomer(CustomerUpdateDto customerUpdateDto) {
        return customerUpdateDto.getId() != null
                && customerUpdateDto.getName() != null
                && customerUpdateDto.getLastname() != null
                && customerUpdateDto.getDocumentNumber() != null
                && customerUpdateDto.getEmail() != null
                && customerUpdateDto.getCustomerType() != null
                && UtilEnum.getByDescription(CostumerTypeEnum.class,
                        customerUpdateDto.getCustomerType()) != null;
    }

}
