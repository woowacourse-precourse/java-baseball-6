package baseball;

import baseball.controller.BaseballGame;
import baseball.view.InputView;

public class Application {
    private static final String RESTART = "1";
    private static final String END = "2";
    private static final String RESTART_OR_END_ONLY_MESSAGE = "1 또는 2를 입력해주세요.";

    public static void main(String[] args) {
        boolean isContinue = true;

        while (isContinue) {
            BaseballGame.run();
            isContinue = restart();
        }
    }

    private static boolean restart() {
        String input = InputView.restartGame();
        if (!input.equals(RESTART) && !input.equals(END)) {
            throw new IllegalArgumentException(RESTART_OR_END_ONLY_MESSAGE);
        }
        return input.equals(RESTART);
    }
}
