package com.nttdatabanking.productservice.util.enumeration;

/**
 * Enumeracion tipo movimiento credito.
 */
public enum CreditMovementTypeEnum implements DescribableEnum {
    PAYMENT("PAGO"),
    CONSUMPTION("CONSUMO");

    private final String description;

    CreditMovementTypeEnum(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
