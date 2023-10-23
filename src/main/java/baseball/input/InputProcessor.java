package baseball.input;

import java.util.List;

public class InputProcessor {
    private final InputHandler inputHandler;
    private final InputValidator inputValidator;


    public InputProcessor(InputHandler inputHandler, InputValidator inputValidator) {
        this.inputHandler = inputHandler;
        this.inputValidator = inputValidator;
    }

    public List<Integer> obtainValidUserGuess(){
        String userInput = inputHandler.readInput();
        validateUserGuess(userInput);
        return inputHandler.convertInputToNumbers(userInput);
    }

    public int obtainValidUserChoice() {
        String userInput= inputHandler.readInput();
        validateUserChoice(userInput);
        return inputHandler.parseRestartChoice(userInput);
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
