package com.hoangyth.utils;

import org.springframework.core.convert.converter.Converter;

public class PermissionTypeEnumConverter implements Converter<String, PermissionType> {
    @Override
    public PermissionType convert(String source) {
        return PermissionType.forValue(source.toUpperCase());
    }
}