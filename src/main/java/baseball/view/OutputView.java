package baseball.view;

import baseball.model.GameMessages;

public class OutputView {

    public void gameStart() {
        System.out.println(GameMessages.GAME_START_GUIDE);
    }

    public void requestInputNumber() {
        System.out.println(GameMessages.NUMBER_REQUEST_MESSAGE);
    }

    public void notifyCorrectAnswer() {
        System.out.println(GameMessages.CORRECT_ANSWER_MESSAGE);
    }

    public void askRestartOrExit() {
        System.out.println(GameMessages.RESTART_OR_EXIT_MESSAGE);
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }
}
