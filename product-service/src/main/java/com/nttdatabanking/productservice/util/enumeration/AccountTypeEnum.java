package com.nttdatabanking.productservice.util.enumeration;

/**
 * Enumeracion tipo cuenta.
 */
public enum AccountTypeEnum implements DescribableEnum {
    SAVINGS("AHORRO"),
    CURRENT("CORRIENTE"),
    FIXEDDEPOSIT("PLAZOFIJO");

    private final String description;

    AccountTypeEnum(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
