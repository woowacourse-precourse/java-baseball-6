package baseball;

import baseball.domain.*;

public class Config {

    public InputOutputHandler inputOutputHandler() {
        return new InputOutputHandler();
    }

    public GameIO gameIO() {return new GameIO(inputOutputHandler());}

    public User user() {
        return new User(gameIO());
    }

    public RandomNumberPicker randomNumberPicker() {
        return new RandomNumberPicker();
    }

    public NumberBaseBall numberBaseBall(int numberLimit) {
        return new NumberBaseBall(
                numberLimit,
                randomNumberPicker(),
                gameIO(),
                user());
    }

}
