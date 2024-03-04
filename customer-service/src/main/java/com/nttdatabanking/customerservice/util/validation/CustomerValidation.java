package com.nttdatabanking.customerservice.util.validation;

import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import com.nttdatabanking.customerservice.util.enumeration.CostumerTypeEnum;
import com.nttdatabanking.customerservice.util.enumeration.UtilEnum;
import org.apache.commons.lang3.StringUtils;
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
        return StringUtils.isNotBlank(customerCreateDto.getName())
                && StringUtils.isNotBlank(customerCreateDto.getLastname())
                && StringUtils.isNotBlank(customerCreateDto.getDocumentNumber())
                && StringUtils.isNotBlank(customerCreateDto.getEmail())
                && StringUtils.isNotBlank(customerCreateDto.getCustomerType())
                && UtilEnum.getByDescription(CostumerTypeEnum.class,
                        customerCreateDto.getCustomerType()) != null;
    }

    /**
     * Metodo validacion actualizacion cliente.
     */
    public static Boolean validateCustomer(CustomerUpdateDto customerUpdateDto) {
        return StringUtils.isNotBlank(customerUpdateDto.getId())
                && StringUtils.isNotBlank(customerUpdateDto.getName())
                && StringUtils.isNotBlank(customerUpdateDto.getLastname())
                && StringUtils.isNotBlank(customerUpdateDto.getDocumentNumber())
                && StringUtils.isNotBlank(customerUpdateDto.getEmail())
                && StringUtils.isNotBlank(customerUpdateDto.getCustomerType())
                && UtilEnum.getByDescription(CostumerTypeEnum.class,
                        customerUpdateDto.getCustomerType()) != null;
    }

}
