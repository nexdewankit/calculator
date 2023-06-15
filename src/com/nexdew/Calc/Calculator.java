package com.nexdew.Calc;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator extends Calc {

    public Calculator() {
        this.initiate();
    }

    private void doAction() {
        var userContinue = askUserInput(Message.CONTINUE_MESSAGE);
        while(null == isValidUserAction(userContinue)) {
            userContinue = askUserInput(Message.CONTINUE_MESSAGE);
        }
        this.setUserAction(isValidUserAction(userContinue));
        if (this.getUserAction().toString().equals("YES")) {
            this.initiate();
        }
    }

    private void initiate() {
        var firstValue = getFirstValue();
        if (null == firstValue) {
            var a = askUserInput(Message.GET_FIRST_NUMBER);
            while (!isValidNumber(a)) {
                print(Message.INVALID_NUMBER_MESSAGE);
                a = askUserInput(Message.GET_FIRST_NUMBER);
            }
            this.setFirstValue(new BigDecimal(a));
        }

        var action = askUserInput(Message.GET_ACTION);
        while (null == getValidAction(action)) {
            print(Message.INVALID_ACTION_MESSAGE);
            action = askUserInput(Message.GET_ACTION);
        }
        this.setAction(getValidAction(action));
        var b = askUserInput(Message.GET_SECOND_NUMBER);
        while (!isValidNumber(b)) {
            print(Message.INVALID_NUMBER_MESSAGE);
            askUserInput(Message.GET_SECOND_NUMBER);
        }
        this.setSecondValue(new BigDecimal(b));
        this.calculate();
        print(this.getResultValue().toString());
        this.doAction();
    }

}