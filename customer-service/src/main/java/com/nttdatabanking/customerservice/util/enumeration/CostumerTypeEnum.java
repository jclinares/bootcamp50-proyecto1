package com.nttdatabanking.customerservice.util.enumeration;

/**
 * Enumeracion tipo cliente.
 */
public enum CostumerTypeEnum implements DescribableEnum {
    PERSONAL("PERSONAL"),
    PERSONALVIP("PERSONALVIP"),
    BUSINESS("EMPRESARIAL"),
    BUSINESSMYPE("EMPRESARIALMYPE");

    private final String description;

    CostumerTypeEnum(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
