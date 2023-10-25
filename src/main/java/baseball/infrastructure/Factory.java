package baseball.infrastructure;

import baseball.application.GameManager;
import baseball.application.Generator;
import baseball.presentation.UserInput;
import baseball.presentation.UserOutput;

public class Factory {
    public GameManager gameManager() {
        return new GameManager(generator(), userInput(), userOutput());
    }

    public Generator generator() {
        return new Generator();
    }

    public UserInput userInput() {
        return new UserInput();
    }

    public UserOutput userOutput() {
        return new UserOutput();
    }

}
