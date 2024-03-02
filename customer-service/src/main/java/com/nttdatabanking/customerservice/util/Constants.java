package com.nttdatabanking.customerservice.util;

/**
 * Clase constantes.
 */
public class Constants {

    private Constants() {
    }

    /**
     * Enum tipo cliente.
     */
    public enum CostumerType {
        PERSONAL("PERSONAL"),
        PERSONALVIP("PERSONALVIP"),
        BUSINESS("EMPRESARIAL"),
        BUSINESSMYPE("EMPRESARIALMYPE");

        private final String description;

        CostumerType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        /**
         * Metodo obtener enum por descripcion.
         */
        public static CostumerType getByDescription(String description) {
            for (CostumerType costumerType : CostumerType.values()) {
                if (costumerType.getDescription().equalsIgnoreCase(description)) {
                    return costumerType;
                }
            }
            return null;
        }
    }

}
