package baseball;

import baseball.domain.*;

public class Config {

    public InputOutputHandler inputOutputHandler() {
        return new InputOutputHandler();
    }

    public Me me() {
        return new Me(inputOutputHandler());
    }

    public NumberBaseBall numberBaseBall() {
        return new NumberBaseBall();
    }

    public RandomNumberPicker randomNumberPicker() {
        return new RandomNumberPicker();
    }

    public Opponent opponent() {
        return new Opponent(
                numberBaseBall(),
                randomNumberPicker(),
                inputOutputHandler(),
                me());
    }
}
