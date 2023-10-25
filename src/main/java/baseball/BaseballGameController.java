package baseball;

import static baseball.BaseballConstants.END_GAME_NUMBER;

public class BaseballGameController {

    private BaseballGameView baseballGameView;
    private Validator terminateValidator;
    private BaseballGame baseballGame;
    private RandomNumberGenerator randomNumberGenerator;

    public BaseballGameController(BaseballGameView baseballGameView, Validator terminateValidator,
        BaseballGame baseballGame, RandomNumberGenerator randomNumberGenerator) {
        this.baseballGameView = baseballGameView;
        this.terminateValidator = terminateValidator;
        this.baseballGame = baseballGame;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playGame() {
        baseballGameView.showStartMessage();
        while (true) {
            BaseballNumber baseballNumber = BaseballNumber.getInstance(randomNumberGenerator);
            baseballGame.play(baseballNumber);
            baseballGameView.showEndMessage();
            String endNumber = baseballGameView.inputNextGameNumber();
            terminateValidator.validate(endNumber);
            if (isEnd(endNumber)) return;
        }
    }

    private boolean isEnd(String input) {
        return (Integer.parseInt(input) == END_GAME_NUMBER);
    }

}
