package com.nttdatabanking.productservice.infraestructure.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class AccountEntity {

    @Id
    private String _id;

    private String accountCustomerType;

    private List<AccountCustomer> accountCustomer;

    private String accountNumber;

    private String accountType;

    private Double availableAmount;

    private Double commission;

    private Integer movementLimits;

    private Integer dayMovement;

}
