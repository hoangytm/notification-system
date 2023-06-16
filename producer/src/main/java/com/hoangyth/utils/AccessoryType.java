package com.hoangyth.utils;

import java.util.HashMap;
import java.util.Map;

public enum AccessoryType {
    ATTACHMENT(1), CHILD_FOLDER(2);
    private static final Map<Integer, AccessoryType> BY_VAL_MAP = new HashMap<>();

    static {
        for (AccessoryType type : AccessoryType.values()) {
            BY_VAL_MAP.put(type.value, type);
        }
    }

    private final Integer value;

    AccessoryType(int value) {
        this.value = value;
    }

    public static AccessoryType forValue(Integer val) {
        return BY_VAL_MAP.get(val);
    }

    public int getValue() {
        return value;
    }

}
