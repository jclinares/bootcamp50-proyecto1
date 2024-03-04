package com.nttdatabanking.productservice.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad credito.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credits")
public class CreditEntity {

    @Id
    private String _id;

    private String customerId;

    private String customerType;

    private String creditNumber;

    private String creditType;

    private Double amount;

    private Double availableAmount;

}
