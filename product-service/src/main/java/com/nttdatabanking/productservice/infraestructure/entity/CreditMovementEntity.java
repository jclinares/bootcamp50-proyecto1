package com.nttdatabanking.productservice.infraestructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "creditmovements")
public class CreditMovementEntity {
    @Id
    private String _id;

    private String description;

    private String creditId;

    private String movementType;

    private Double amount;
}
