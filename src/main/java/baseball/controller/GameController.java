package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    static String userInput;

    public static void getUserInput() {
        userInput = Console.readLine();
    }
}
