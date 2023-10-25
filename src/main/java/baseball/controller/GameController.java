package baseball.controller;

import baseball.service.BaseballGame;
import baseball.utils.InputUtil;
import baseball.utils.OutputUtil;

public class GameController implements BaseballGame {

    private static final String RESTART = "1";
    private static final String FINISH = "2";
    private static final String IS_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private GameController() {}
    public static void play() {
        viewStartMessage();
        boolean gameContinue = true;
        while (gameContinue) {
            BaseballGame.play();
            viewEndMessage();
            viewIsContinueMessage();
            gameContinue = isRestart(InputUtil.stringInput());
        }
    }

    private static void viewStartMessage() {
        OutputUtil.printlnString(BaseballGame.START_MESSAGE);
    }

    private static void viewEndMessage() {
        OutputUtil.printlnString(BaseballGame.END_MESSAGE);
    }

    private static void viewIsContinueMessage() {
        OutputUtil.printlnString(IS_CONTINUE_MESSAGE);
    }

    private static boolean isRestart(final String value) {
        if (value.equals(RESTART)) {
            return true;
        }
        if (value.equals(FINISH)) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");

    }
}
