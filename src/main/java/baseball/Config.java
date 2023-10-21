package baseball;

import baseball.domain.*;

public class Config {

    public InputOutputHandler inputOutputHandler() {
        return new InputOutputHandler();
    }

    public NumberBaseballIO numberBaseballIO() {return new NumberBaseballIO(inputOutputHandler());}

    public User user() {
        return new User(numberBaseballIO());
    }

    public RandomNumberPicker randomNumberPicker() {
        return new RandomNumberPicker();
    }

    public NumberBaseball numberBaseball(int numberLimit) {
        return new NumberBaseball(
                numberLimit,
                randomNumberPicker(),
                numberBaseballIO(),
                user());
    }

}
