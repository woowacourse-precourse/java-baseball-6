package io;

import static constant.Constant.ENTER_NUMBER_MESSAGE;
import static constant.Constant.RESTART_MESSAGE;

import baseball.game.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import validation.BaseballGameInputValidator;

public class GameUserInterface {
    private final Converter converter;

    public GameUserInterface(Converter converter) {
        this.converter = converter;
    }

    private String printEnterNumberMessageAndReceiveInput(String messageForPrint, boolean isRestart) {
        String userInputString = printStartMessageAndReceiveInput(messageForPrint, isRestart);
        BaseballGameInputValidator.validateInput(userInputString);
        return userInputString;
    }

    public String printRestartMessageAndReceiveInput() {
        return printEnterNumberMessageAndReceiveInput(RESTART_MESSAGE, true);
    }

    public List<Integer> printEnterNumberMessageAndReceiveInput() {
        String inputString = printEnterNumberMessageAndReceiveInput(ENTER_NUMBER_MESSAGE, false);
        return converter.convertToInputNumbers(inputString);
    }

    public String printStartMessageAndReceiveInput(String message, boolean isRestart) {
        if (isRestart) {
            println(message);
        } else {
            print(message);
        }
        String received = Console.readLine();
        println(received);
        return received;
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }
}