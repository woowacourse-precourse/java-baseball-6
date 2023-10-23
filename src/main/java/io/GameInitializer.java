package io;

import camp.nextstep.edu.missionutils.Console;
import validation.BaseballGameInputValidator;

public class GameInitializer {
    private final Prompt prompt;

    public GameInitializer(Prompt prompt) {
        this.prompt = prompt;
    }

    public String initNewGame(String messageForPrint, boolean isRestart) {
        String userInputString = printStartMessageAndReceiveInput(messageForPrint, isRestart);
        BaseballGameInputValidator.validateInput(userInputString);
        return userInputString;
    }

    public String initNewGame(String messageForPrint) {
        return initNewGame(messageForPrint, false);
    }

    public String printStartMessageAndReceiveInput(String message, boolean isRestart) {
        if (isRestart) {
            prompt.println(message);
        } else {
            prompt.print(message);
        }
        String received = Console.readLine();
        prompt.println(received);
        return received;
    }
}