package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.BaseballNumbersFactory;
import baseball.utils.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {

    private static final String GAME_RESTART = "1";
    private static final String GAME_OVER = "2";
    private static final int NUMBERS_LENGTH = 3;

    public static void playGames() {
        OutputView.printGameStart();
        do {
            playGameOnce();
            OutputView.printAnswer();
        } while (getGameRestart().equals(GAME_RESTART));
    }

    public static void playGameOnce() {
        List<BaseballNumber> randomBaseballNumbers = BaseballNumbersFactory.getRandomBaseballNumbers();
        int ballCount;
        int strikeCount;
        do {
            List<BaseballNumber> userBaseballNumbers = getUserBaseballNumbers();
            ballCount = getBallCount(randomBaseballNumbers, userBaseballNumbers);
            strikeCount = getStrikeCount(randomBaseballNumbers, userBaseballNumbers);
            OutputView.printBallStrikeCount(ballCount, strikeCount);
        } while (!isAnswer(strikeCount));
    }

    public static List<BaseballNumber> getUserBaseballNumbers() {
        String baseballNumbersString = InputView.getConsoleInput();
        return BaseballNumbersFactory.getBaseballNumbers(baseballNumbersString);
    }

    public static int getBallCount(List<BaseballNumber> randomBaseballNumbers,
                                   List<BaseballNumber> userBaseballNumbers) {
        int ballCount = 0;
        for (int i = 0; i < userBaseballNumbers.size(); i++) {
            BaseballNumber userBaseballNumber = userBaseballNumbers.get(i);
            BaseballNumber randomBaseballNumber = randomBaseballNumbers.get(i);
            if (!userBaseballNumber.equals(randomBaseballNumber) &&
                    randomBaseballNumbers.contains(userBaseballNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static int getStrikeCount(List<BaseballNumber> randomBaseballNumbers,
                                     List<BaseballNumber> userBaseballNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < userBaseballNumbers.size(); i++) {
            BaseballNumber userBaseballNumber = userBaseballNumbers.get(i);
            BaseballNumber randomBaseballNumber = randomBaseballNumbers.get(i);
            if (userBaseballNumber.equals(randomBaseballNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static boolean isAnswer(int strikeCount) {
        return strikeCount == NUMBERS_LENGTH;
    }

    public static String getGameRestart() {
        String gameRestartOrNot = InputView.getConsoleInput();
        Validation.validateGameRestartOrNot(gameRestartOrNot, GAME_RESTART, GAME_OVER);
        return gameRestartOrNot;
    }
}
