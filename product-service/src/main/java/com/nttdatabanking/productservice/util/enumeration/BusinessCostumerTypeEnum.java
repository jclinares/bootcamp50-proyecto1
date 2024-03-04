package com.nttdatabanking.productservice.util.enumeration;

/**
 * Enumeracion tipo cliente empresarial.
 */
public enum BusinessCostumerTypeEnum implements DescribableEnum {
    HEADLINE("TITULAR"),
    SIGNATORY("FIRMANTE");

    private final String description;

    BusinessCostumerTypeEnum(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
