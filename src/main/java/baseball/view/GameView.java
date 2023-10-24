package baseball.view;


import static baseball.constant.GameConstant.GAME_END;
import static baseball.constant.GameConstant.GAME_START;
import static baseball.constant.GameConstant.INPUT_NUMBER;
import static baseball.constant.GameConstant.RESTART_OR_EXIT;

import baseball.domain.GameResult;

/**
 * 게임 뷰
 */

public class GameView {

    public static void gameStartView() {
        System.out.println(GAME_START);
    }

    public static void userInputView() {
        System.out.print(INPUT_NUMBER);
    }

    public static void gameResultView(GameResult gameResult) {
        System.out.println(gameResult.result());
    }

    public static void gameEndView() {
        System.out.println(GAME_END);
    }

    public static void restartOrExitView() {
        System.out.println(RESTART_OR_EXIT);
    }
}
