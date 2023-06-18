package com.hoangyth.utils;

import java.util.HashMap;
import java.util.Map;

/*the higher permission will have higher value*/
public enum PermissionType {

    READ(1), WRITE(2);
    private static final Map<Integer, PermissionType> BY_VAL_MAP = new HashMap<>();

    static {
        for (PermissionType type : PermissionType.values()) {
            BY_VAL_MAP.put(type.value, type);
        }
    }

    private final Integer value;

    PermissionType(Integer value) {
        this.value = value;
    }

    /**
     * @param val
     * @return
     */
    public static PermissionType forValue(Integer val) {
        return BY_VAL_MAP.get(val);
    }

    public Integer getValue() {
        return value;
    }
}