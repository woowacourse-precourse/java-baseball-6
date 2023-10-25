package baseball.input;

import baseball.input.converter.InputConverter;
import baseball.input.validator.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GuessInputProcessor {
    private final InputConverter inputConverter;
    private final Validator validator;

    public GuessInputProcessor(InputConverter inputConverter, Validator validator) {
        this.inputConverter = inputConverter;
        this.validator = validator;
    }

    public List<Integer> obtainValidUserGuess(){
        String userInput = readLine();
        validator.validate(userInput);
        return inputConverter.convertInputToNumbers(userInput);
    }
}
