package com.nttdatabanking.productservice.util.enumeration;

/**
 * Enumeracion tipo credito.
 */
public enum CreditTypeEnum implements DescribableEnum {

    PERSONAL("PERSONAL"),
    BUSINESS("EMPRESARIAL"),
    CREDITCARD("TARJETACREDITO");

    private final String description;

    CreditTypeEnum(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
