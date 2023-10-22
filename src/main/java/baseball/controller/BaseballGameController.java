package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumbers;
import baseball.model.BaseballNumbersGenerator;
import baseball.model.GameRestartOrNot;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    public static void playGames() {
        OutputView.printGameStart();
        while (true) {
            playGameOnce();
            GameRestartOrNot gameRestartOrNot = InputView.getGameRestartOrNot();
            if (!gameRestartOrNot.doesRestart()) {
                break;
            }
        }
    }

    private static void playGameOnce() {
        BaseballGame baseballGame = getBaseballGame();
        while (true) {
            OutputView.printBallStrikeResult(baseballGame.getBallCount(), baseballGame.getStrikeCount());
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
}
