package baseball.view;

import baseball.constants.Message;

public class OutputView {
    public void printStart() {
        System.out.println(Message.GAME_START);
    }

    public void printUserGuess() {
        System.out.println(Message.USER_PROMPT);
    }
}
