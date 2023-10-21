package baseball.service;

import static baseball.utils.BaseballGamePrinterUtils.announcePlayerWin;
import static baseball.utils.BaseballGamePrinterUtils.announceStartGame;
import static baseball.utils.BaseballGameReaderUtils.askStartNewGame;
import static baseball.utils.BaseballGameReaderUtils.getPlayerTargetNums;

import java.util.List;

public class BaseballGameService {
    public static void startGame() {
        announceStartGame();
        boolean isGameStart = true;
        while (isGameStart) {
            playBaseballGame();
            isGameStart = askStartNewGame();
        }
    }

    private static void playBaseballGame() {
        BaseballGame baseballGame = new BaseballGame();
        while (true) {
            List<Integer> playerTargetNums = getPlayerTargetNums();
            if (baseballGame.isPlayerWin(playerTargetNums)) {
                announcePlayerWin();
                return;
            }
        }
    }
}
