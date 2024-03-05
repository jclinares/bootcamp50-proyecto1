package com.nttdatabanking.productservice.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad cuenta movimiento.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accountmovements")
public class AccountMovementEntity {
    @Id
    private String _id;

    private String accountId;

    private String accountType;

    private String description;

    private String movementType;

    private Double amount;

    private String movementDate;
}
