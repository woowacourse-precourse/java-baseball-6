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
        inputValidator.validateUserGuess(userInput);
        return inputConverter.convertInputToNumbers(userInput);
    }

    public int obtainValidUserChoice() {
        String userInput= readLine();
        inputValidator.validateUserChoice(userInput);
        return inputConverter.parseRestartChoice(userInput);
    }
}
