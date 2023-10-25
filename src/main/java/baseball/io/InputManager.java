package baseball.io;

import baseball.utils.InputUtils;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.function.Predicate;

public class InputManager {
    private final InputValidator validator;
    private final OutputManager outputManager;

    public InputManager() {
        this.validator = new InputValidator();
        this.outputManager = new OutputManager();
    }

    public List<Integer> readInput() {
        outputManager.printGuessMessage();
        return InputUtils.parseInput(prompt(validator::isValidInput));
    }

    public String readReplayOrStopInput() {
        outputManager.printReplayOrStopMessage();
        return prompt(validator::isReplayOrStopInputValid);
    }

    private String prompt(Predicate<String> validator) {
        String input = Console.readLine();
        if (!validator.test(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
