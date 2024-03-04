package com.nttdatabanking.productservice.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase entidad cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    private String customerId;

    private String customerType;

    private String businessCustomerType;

}
