package com.nttdatabanking.customerservice.util.enumeration;

/**
 * Clase util enumeracion.
 */
public class UtilEnum {
    public static <E extends Enum<E> & DescribableEnum> E getByDescription(Class<E> enumClass, String description) {
        for (E item : enumClass.getEnumConstants()) {
            if (item.getDescription().equalsIgnoreCase(description)) {
                return item;
            }
        }
        return null;
    }
}
