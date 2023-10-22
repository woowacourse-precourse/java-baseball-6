package baseball.controller;

import baseball.domain.Computer;
import baseball.view.BaseBallView;


public class GameController {

    private static final String CONTINUE_GAME_SIG = "1";
    private static final String END_GAME_SIG = "2";
    private static final BaseBallView baseBallView  = BaseBallView.create();

    private GameController() {
    }

    public static void run() {
        baseBallView.startGameView();

        boolean isContinueGame = true;

        while (isContinueGame) {
            isContinueGame = startGame();
        }
    }

    private static boolean startGame() {
        Computer computer = Computer.create();
        PlayerController.startBattles(computer.getPlayer());

        return checkIsContinueGame(baseBallView.continueInputView());
    }

    private static boolean checkIsContinueGame(String continueInputString) {
        if (continueInputString.equals(CONTINUE_GAME_SIG)) {
            return true;
        }
        if (continueInputString.equals(END_GAME_SIG)) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }

}
