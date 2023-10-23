package controller;

import static view.InputView.getUserNumbersInput;

import vo.UserNumbers;

public class BaseballController {

    public static void gameStart() {
        UserNumbers userNumbersInput = getUserNumbersInput();
        System.out.println("userNumbersInput = " + userNumbersInput);
    }
}
