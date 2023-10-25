package baseball.controller;

import static baseball.domain.Score.THREE_STRIKE;

import baseball.domain.BaseBallGame;
import baseball.view.InputDevice;
import baseball.view.OutputDevice;
import baseball.domain.Score;
import java.util.List;

public class BaseBallGameController {

    private final InputDevice inputDevice;
    private final BaseBallGame baseBallGame;
    private final OutputDevice outputDevice;

    public BaseBallGameController(InputDevice inputDevice, BaseBallGame baseBallGame, OutputDevice outputDevice) {
        this.inputDevice = inputDevice;
        this.baseBallGame = baseBallGame;
        this.outputDevice = outputDevice;
    }

    public Score competeWith(List<Integer> answerNumbers) {
        Score gameResult;
        do {
            List<Integer> tryNumbers = inputDevice.inputTryNumber();
            gameResult = baseBallGame.createGameResult(tryNumbers, answerNumbers);
            outputDevice.printGameResult(gameResult.getName());
        } while (notThreeStrike(gameResult));
        return gameResult;
    }

    private boolean notThreeStrike(Score gameResult) {
        return gameResult != THREE_STRIKE;
    }
}
