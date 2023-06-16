package com.hoangyth.utils;

public enum FolderType {

    DEPT(1), INDIVIDUALITY(2);
    private final int value;

    FolderType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}


