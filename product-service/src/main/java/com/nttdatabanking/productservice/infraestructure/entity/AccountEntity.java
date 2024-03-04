package com.nttdatabanking.productservice.infraestructure.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad cuenta.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class AccountEntity {

    @Id
    private String _id;

    private String customerType;

    private List<CustomerEntity> customerList;

    private String accountNumber;

    private String accountType;

    private Double availableAmount;

    private Double commission;

    private Integer movementLimits;

    private Integer dayMovement;

}
