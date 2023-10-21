package baseball.service;

import static baseball.utils.BaseballGamePrinterUtils.announcePlayerWin;
import static baseball.utils.BaseballGamePrinterUtils.announceStartGame;
import static baseball.utils.BaseballGameReaderUtils.askStartNewGame;
import static baseball.utils.BaseballGameReaderUtils.getPlayerTargetNums;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.VisibleForTesting;

public class BaseballGameService {

    private static final int NUMBER_SIZE_TO_GAME = 3;
    private static final int MIN_RANDOM_GAME_NUM = 1;
    private static final int MAX_RANDOM_GAME_NUM = 9;

    public static void startGame() {
        announceStartGame();
        boolean isGameStart = true;
        while (isGameStart) {
            playBaseballGame();
            isGameStart = askStartNewGame();
        }
    }

    private static void playBaseballGame() {
        BaseballGame baseballGame = new BaseballGame(generateRandomNums());
        while (true) {
            List<Integer> playerTargetNums = getPlayerTargetNums();
            if (baseballGame.isPlayerWin(playerTargetNums)) {
                announcePlayerWin();
                return;
            }
        }
    }

    @VisibleForTesting
    protected static List<Integer> generateRandomNums() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_SIZE_TO_GAME) {
            int randomNumber =
                    Randoms.pickNumberInRange(MIN_RANDOM_GAME_NUM, MAX_RANDOM_GAME_NUM);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
