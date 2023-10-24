package baseball;

import java.util.List;

public class BaseBallGameController {

    private final InputDevice inputDevice;
    private final BaseBallGame baseBallGame;

    public BaseBallGameController(InputDevice inputDevice, BaseBallGame baseBallGame) {
        this.inputDevice = inputDevice;
        this.baseBallGame = baseBallGame;
    }

    public String competeWith(List<Integer> answerNumbers) {
        String gameResult;
        do {
            List<Integer> tryNumbers = inputDevice.inputTryNumber();
            gameResult = baseBallGame.createGameResult(tryNumbers, answerNumbers);
            System.out.println(gameResult);
        } while (notThreeStrike(gameResult));
        return gameResult;
    }

    private boolean notThreeStrike(String gameResult) {
        return !gameResult.equals(Score.THREE_STRIKE.getName());
    }
}
