package baseball;

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

    public String competeWith(List<Integer> answerNumbers) {
        String gameResult;
        do {
            List<Integer> tryNumbers = inputDevice.inputTryNumber();
            gameResult = baseBallGame.createGameResult(tryNumbers, answerNumbers);
            outputDevice.printGameResult(gameResult);
        } while (notThreeStrike(gameResult));
        return gameResult;
    }

    private boolean notThreeStrike(String gameResult) {
        return !gameResult.equals(Score.THREE_STRIKE.getName());
    }
}
