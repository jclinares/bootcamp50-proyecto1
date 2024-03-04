package com.nttdatabanking.productservice.util.enumeration;

/**
 * Enumeracion tipo movimiento cuenta.
 */
public enum AccountMovementTypeEnum implements DescribableEnum {
    DEPOSIT("DEPOSITO"),
    WITHDRAWAL("RETIRO");

    private final String description;

    AccountMovementTypeEnum(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
