package com.nexdew.Calc;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator extends Calc {

    public Calculator() {
        this.initiate();
    }

    private void initiate() {
       this.getUserFirstNumber();
       this.getUserOperation();
       this.getUserSecondNumber();
       this.doAction();
    }

    private void getUserFirstNumber() {
        var firstValue = getFirstValue();
        if (null == firstValue) {
            var a = askUserInput(Message.GET_FIRST_NUMBER);
            while (!isValidNumber(a)) {
                print(Message.INVALID_NUMBER_MESSAGE);
                a = askUserInput(Message.GET_FIRST_NUMBER);
            }
            this.setFirstValue(new BigDecimal(a));
        }
    }

    private void getUserOperation() {
        var action = askUserInput(Message.GET_ACTION);
        while (null == getValidAction(action)) {
            print(Message.INVALID_ACTION_MESSAGE);
            action = askUserInput(Message.GET_ACTION);
        }
        this.setAction(getValidAction(action));
    }

    private void getUserSecondNumber() {
        var b = askUserInput(Message.GET_SECOND_NUMBER);
        while (!isValidNumber(b)) {
            print(Message.INVALID_NUMBER_MESSAGE);
            b = askUserInput(Message.GET_SECOND_NUMBER);
        }
        this.setSecondValue(new BigDecimal(b));
        this.calculate();
        print(this.getResultValue().toString());
    }

    private void doAction() {
        var userContinue = askUserInput(Message.CONTINUE_MESSAGE);
        while (null == isValidUserAction(userContinue)) {
            userContinue = askUserInput(Message.CONTINUE_MESSAGE);
        }
        this.setUserAction(isValidUserAction(userContinue));
        if (this.getUserAction().equals(UserAction.YES)) {
            this.initiate();
        } else {
            print(Message.FINAL_VALUE_MESSAGE + this.getResultValue());
        }
    }

}