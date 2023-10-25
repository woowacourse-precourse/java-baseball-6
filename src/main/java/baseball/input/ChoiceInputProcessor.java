package baseball.input;

import baseball.input.converter.InputConverter;
import baseball.input.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ChoiceInputProcessor {
    private final InputConverter inputConverter;
    private final Validator validator;

    public ChoiceInputProcessor(InputConverter inputConverter, Validator validator) {
        this.inputConverter = inputConverter;
        this.validator = validator;
    }

    public int obtainValidUserChoice() {
        String userInput= readLine();
        validator.validate(userInput);
        return inputConverter.parseRestartChoice(userInput);
    }
}
