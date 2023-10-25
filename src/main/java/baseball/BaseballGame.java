package baseball;

import static baseball.BaseballConstants.*;

public class BaseballGame {

    private BaseballGameView baseballGameView;
    private Validator baseballNumValidator;

    public BaseballGame(BaseballGameView baseballGameView, Validator baseballNumValidator) {
        this.baseballGameView = baseballGameView;
        this.baseballNumValidator = baseballNumValidator;
    }

    public void play(BaseballNumber baseballNumber) {
        while (true) {
            String inputNumber = baseballGameView.inputBaseballNumber();
            baseballNumValidator.validate(inputNumber);
            String result = baseballNumber.compare(inputNumber);
            baseballGameView.print(result);
            if (isAllStrike(result)) {
                break;
            }
        }
    }

    private boolean isAllStrike(String result) {
        return result.equals(ALL_STRIKE);
    }
}
