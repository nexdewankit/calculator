package com.nexdew.Calc;

public enum UserAction {
    YES("y"),
    NO("n");

    private final String value;

    UserAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
