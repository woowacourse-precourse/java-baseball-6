package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public String requestPlayerGuess() {
        return Console.readLine();
    }

    public String requestRestartChoice() {
        return Console.readLine();
    }
}
