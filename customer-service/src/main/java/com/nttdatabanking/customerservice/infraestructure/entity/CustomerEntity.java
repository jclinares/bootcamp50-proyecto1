package com.nttdatabanking.customerservice.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String _id;

    private String name;

    private String lastname;

    private String documentNumber;

    private String email;

    private String customerType;

}
