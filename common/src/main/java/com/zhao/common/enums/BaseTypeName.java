package com.zhao.common.enums;

public enum BaseTypeName {
    INTEGER(Integer.class.getName()),
    LONG(Long.class.getName()),
    FLOAT(Float.class.getName()),
    DOUBLE(Double.class.getName()),
    CHAR(Character.class.getName()),
    STRING(String.class.getName()),
    BOOLEAN(String.class.getName());

    private final String Type;

    BaseTypeName(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }
}
