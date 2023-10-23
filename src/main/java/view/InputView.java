package view;

import camp.nextstep.edu.missionutils.Console;
import utils.BaseballNumberUtils;
import view.processing.Convertor;
import view.processing.Validator;

import java.util.ArrayList;
import java.util.List;

import static utils.GameErrorMessage.INVALID_CONVERT_MESSAGE;

public class InputView {

    private final Convertor convertor;
    private final Validator validator;

    public InputView(Convertor convertor, Validator validator) {
        this.convertor = convertor;
        this.validator = validator;
    }

    public String readInput() {
        return Console.readLine();
    }

    public List<Integer> readInputNumbers() {
        String input = readInput();
        if (validator.isBaseballNumber(input)) {
            return convertor.convertStringToBaseballNumber(input);
        }
        throw new IllegalArgumentException(INVALID_CONVERT_MESSAGE);
    }

}
