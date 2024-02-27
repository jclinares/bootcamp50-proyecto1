package com.nttdatabanking.productservice.infraestructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credits")
public class CreditEntity {

    @Id
    private String _id;

    private String customerId;

    private String creditNumber;

    private String creditType;

    private Double limitAmount;

    private Double availableAmount;

}
