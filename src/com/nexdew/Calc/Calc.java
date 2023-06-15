package com.nexdew.Calc;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calc {
    private BigDecimal firstValue;
    private BigDecimal secondValue;
    private BigDecimal ResultValue;
    private Action action;

    private UserAction userAction;

    public UserAction getUserAction() {
        return userAction;
    }

    public void setUserAction(UserAction userAction) {
        this.userAction = userAction;
    }
    public BigDecimal getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(BigDecimal firstValue) {
        this.firstValue = firstValue;
    }

    public BigDecimal getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(BigDecimal secondValue) {
        this.secondValue = secondValue;
    }

    public BigDecimal getResultValue() {
        return ResultValue;
    }

    public void setResultValue(BigDecimal resultValue) {
        ResultValue = resultValue;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean isValidNumber(String a) {
        try {
            new BigDecimal(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Action getValidAction(String action) {
        Action validAction = null;
        for (Action a : Action.values()) {
            if (a.getValue().equalsIgnoreCase(action)) {
                validAction = a;
                break;
            }
        }
        return validAction;
    }

    public UserAction isValidUserAction(String userAction) {
        UserAction validAction = null;
        for (UserAction a: UserAction.values()) {
            if(a.getValue().equalsIgnoreCase(userAction)) {
                validAction = a;
                break;
            }
        }
        return validAction;
    }

    public String askUserInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void calculate() {
        try {
            BigDecimal result = new BigDecimal(Message.DEFAULT_VALUE);
            switch (this.action) {
                case PLUS -> result = addition(this.firstValue, this.secondValue);
                case MINUS -> result = subtract(this.firstValue, this.secondValue);
                case DIVIDE -> result = divide(this.firstValue, this.secondValue);
                case MULTIPLY -> result = multiply(this.firstValue, this.secondValue);
                default -> print(Message.SYSTEM_ERR_MESSAGE);
            }
            this.setResultValue(result);
            setFirstValue(result);
        } catch (NullPointerException e) {
            print(e.getMessage());
        }
    }

    private BigDecimal addition(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    private BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    private BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    private BigDecimal divide(BigDecimal a, BigDecimal b) {
        return a.divide(b);
    }

}
