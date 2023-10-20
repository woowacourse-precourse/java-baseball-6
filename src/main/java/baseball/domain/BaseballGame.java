package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.GameMessage.GET_USER_INPUT;
import static baseball.constants.GameMessage.START_MESSAGE;

public class BaseballGame {
    private Answer answer;
    private Rule rule;

    public BaseballGame() {
        rule = new Rule();
    }

    public void run() {
        System.out.println(START_MESSAGE);
        start();
    }

    private void start() {
        while (true) {
            String userInput = getUserInput();
        }
    }

    private static String getUserInput() {
        System.out.print(GET_USER_INPUT);
        return Console.readLine();
    }
}
