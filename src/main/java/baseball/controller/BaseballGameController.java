package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumbers;
import baseball.model.BaseballNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private static final String GAME_RESTART = "1";
    private static final String GAME_OVER = "2";

    public static void playGames() {
        OutputView.printGameStart();
        String gameRestartOrNot = GAME_RESTART;
        while (GAME_RESTART.equals(gameRestartOrNot)) {
            playGameOnce();
            gameRestartOrNot = getGameRestartOrNot();
        }
    }

    private static void playGameOnce() {
        BaseballGame baseballGame = getBaseballGame();
        while (true) {
            OutputView.printBallStrikeCount(baseballGame.getBallCount(), baseballGame.getStrikeCount());
            if (baseballGame.isAnswer()) {
                break;
            }
            BaseballNumbers userBaseballNumbers = BaseballNumbersGenerator.getUserBaseballNumbers(
                    InputView.getUserBaseballNumbersString());
            baseballGame.resetUserBaseballNumbers(userBaseballNumbers);
        }
    }

    private static BaseballGame getBaseballGame() {
        BaseballNumbers computerBaseballNumbers = BaseballNumbersGenerator.getComputerBaseballNumbers();
        BaseballNumbers userBaseballNumbers = BaseballNumbersGenerator.getUserBaseballNumbers(
                InputView.getUserBaseballNumbersString());
        return new BaseballGame(computerBaseballNumbers, userBaseballNumbers);
    }

    private static String getGameRestartOrNot() {
        String gameRestartOrNot = InputView.getRestartOrNot();
        validateGameRestartOrNot(gameRestartOrNot);
        return gameRestartOrNot;
    }

    private static void validateGameRestartOrNot(String gameRestartOrNot) {
        if (!GAME_RESTART.equals(gameRestartOrNot) && !GAME_OVER.equals(gameRestartOrNot)) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 " + GAME_RESTART + " 또는 " + GAME_OVER + " 가 아닙니다.");
        }
    }
}
