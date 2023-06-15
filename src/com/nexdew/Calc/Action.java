package com.nexdew.Calc;

public enum Action {

    PLUS(Message.SYMBOL_PLUS),
    MINUS(Message.SYMBOL_MINUS),
    MULTIPLY(Message.SYMBOL_MULTIPLY),
    DIVIDE(Message.SYMBOL_DIVIDE);

    private final String value;

    Action(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
