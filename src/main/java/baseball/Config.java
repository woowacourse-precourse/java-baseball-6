package baseball;

import baseball.domain.*;

public class Config {

    public InputOutputHandler inputOutputHandler() {
        return new InputOutputHandler();
    }

    public Me me() {
        return new Me(inputOutputHandler());
    }

    public RandomNumberPicker randomNumberPicker() {
        return new RandomNumberPicker();
    }

    public NumberBaseBall numberBaseBall() {
        return new NumberBaseBall(
                randomNumberPicker(),
                inputOutputHandler(),
                me());
    }

}
