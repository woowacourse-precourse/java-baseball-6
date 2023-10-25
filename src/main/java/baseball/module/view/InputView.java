package baseball.module.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.global.utils.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String SEPARATOR = "";
    private OutputView outputView = new OutputView();

    public List<Integer> readPlayerNumber() {
        String[] inputNumbers = readNumber();

        return Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] readNumber() {
        outputView.printRequestInputMessage();
        String[] inputNumbers = readLine().split(SEPARATOR);

        Validator.validatePlayerNumber(inputNumbers);
        return inputNumbers;
    }

    public String readRestartStatus() {
        outputView.printSelectRestartMessage();
        String option = readLine();

        Validator.validateRestartStatus(option);
        return option;
    }
}
