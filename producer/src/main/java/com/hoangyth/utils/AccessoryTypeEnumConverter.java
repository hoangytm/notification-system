package com.hoangyth.utils;

import org.springframework.core.convert.converter.Converter;

public class AccessoryTypeEnumConverter implements Converter<String, AccessoryType> {

    @Override
    public AccessoryType convert(String source) {
        return AccessoryType.forValue(Integer.valueOf(source));
    }
}
