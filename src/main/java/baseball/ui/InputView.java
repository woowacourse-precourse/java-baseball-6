package baseball.ui;

import java.util.Arrays;
import java.util.List;

import static baseball.global.Validator.*;
import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    private final OutputView outputView;

    private static final String SEPARATOR = "";

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<Integer> readPlayerNumbers() {
        outputView.printInputNumber();
        String[] input = readNumber();
        validatePlayerInput(input);

        return Arrays.stream(input)
                .map(Integer::parseInt)
                .toList();
    }

    private String[] readNumber() {
        String[] inputNumbers = readLine().split(SEPARATOR);

        return inputNumbers;
    }

    public String readRestart() {
        outputView.printGameRestart();
        String option = readLine();

        validateRestart(option);
        return option;
    }
}
