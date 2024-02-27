package com.nttdatabanking.productservice.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCustomer {

    private String customerId;

    private String customerType;

    private String businessCustomerType;

}
