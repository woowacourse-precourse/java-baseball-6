package baseball.input;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputProcessor {
    private final InputConverter inputConverter;
    private final InputValidator inputValidator;

    public InputProcessor(InputConverter inputConverter, InputValidator inputValidator) {
        this.inputConverter = inputConverter;
        this.inputValidator = inputValidator;
    }

    public List<Integer> obtainValidUserGuess(){
        String userInput = readLine();
        validateUserGuess(userInput);
        return inputConverter.convertInputToNumbers(userInput);
    }

    public int obtainValidUserChoice() {
        String userInput= readLine();
        validateUserChoice(userInput);
        return inputConverter.parseRestartChoice(userInput);
    }

    private void validateUserChoice(String userInput) {
        inputValidator.validateNotNull(userInput);
        inputValidator.validateIsInteger(userInput);
        inputValidator.validateChoice(userInput);
    }

    private void validateUserGuess(String userInput) {
        inputValidator.validateNotNull(userInput);
        inputValidator.validateIsInteger(userInput);
        inputValidator.validateLength(userInput);
        inputValidator.validateNoDuplicate(userInput);
    }
}
