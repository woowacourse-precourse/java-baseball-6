package baseball;

import baseball.domain.*;

public class Config {

    public InputOutputHandler inputOutputHandler() {
        return new InputOutputHandler();
    }

    public User user() {
        return new User(inputOutputHandler());
    }

    public RandomNumberPicker randomNumberPicker() {
        return new RandomNumberPicker();
    }

    public NumberBaseBall numberBaseBall() {
        return new NumberBaseBall(
                randomNumberPicker(),
                inputOutputHandler(),
                user());
    }

}
