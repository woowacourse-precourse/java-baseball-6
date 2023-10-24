package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import view.processing.Convertor;
import view.processing.Validator;

public final class InputView {

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
        validator.validateBaseballNumber(input);
        return convertor.inputToBaseballNumber(input);
    }

}
