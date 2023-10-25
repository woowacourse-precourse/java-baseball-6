package baseball.controller;

import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InteractionController {
    private final Validator validator;

    public InteractionController(Validator validator) {
        this.validator = validator;
    }

    public String readInputData() {
        String inputData = Console.readLine();
        validator.validateInputData(inputData);
        return inputData;
    }

    public Integer readChoiceData() {
        String choiceData = Console.readLine();
        validator.validateChoiceData(choiceData);
        return Integer.valueOf(choiceData);
    }
}
