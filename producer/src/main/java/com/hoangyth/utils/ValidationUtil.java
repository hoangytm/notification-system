package com.hoangyth.utils;

import java.lang.reflect.Field;

public class ValidationUtil {
    public  static <T> void trimObjectPeroperty(T entity) throws IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if ((field.get(entity) instanceof String)) {
                field.set(entity,
                        field.get(entity) != null && !""
                                .equals(field.get(entity).toString()) ?
                                field.get(entity).toString().trim() : null);
            }
        }
    }
}
