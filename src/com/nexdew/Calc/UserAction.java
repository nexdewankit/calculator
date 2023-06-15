package com.nexdew.Calc;

public enum UserAction {
    YES(Message.TEXT_YES),
    NO(Message.TEXT_NO);

    private final String value;

    UserAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
