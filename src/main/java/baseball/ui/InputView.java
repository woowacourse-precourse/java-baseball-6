package baseball.ui;

import baseball.global.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    private final static String SEPARATOR = "";


    public List<Integer> readPlayerNumber() {
        String[] inputNumbers = readNumber();

        return Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] readNumber() {
        outputView.printNumberInputMessage();
        String[] inputNumbers = readLine().split(SEPARATOR);

        Validator.validatePlayerNumber(inputNumbers);
        return inputNumbers;
    }

    public String readRestartOrNot() {
        outputView.printRestartSelectMessage();
        String selectOption = readLine();

        validateRestartOrNotValue(selectOption);
        return selectOption;

    }

    private static void validateRestartOrNotValue(String selectOption) {
        Validator.validateNumberFormat(selectOption);
        Validator.validateSelectOptionType(selectOption);
    }

    private String readLine() {
        return Console.readLine();
    }
}
