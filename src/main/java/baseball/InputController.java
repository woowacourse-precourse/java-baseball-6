package baseball;

import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class InputController {

    public static final String DELIMITER = "";
    private final InputView inputView = new InputView();

    public void printStart() {
        inputView.printStart();
    }

    public List<Integer> getPlayerNumbers() {

        String input = inputView.getPlayerNumbers();

        validateInput(input);

        return toPlayerNumbers(input);
    }

    public String getRestartCommand() {
        String input = inputView.getRestartCommand();
        validateInput(input);
        return input;
    }

    private List<Integer> toPlayerNumbers(String input) {
        String[] splitResult = splitByDelimiter(input);
        return Arrays.stream(splitResult)
                .map(Integer::parseInt)
                .toList();
    }

    private String[] splitByDelimiter(String input) {
        return input.split(DELIMITER);
    }

    private void validateInput(String input) {
        validateIsBlank(input);
        validateIsInteger(input);
    }


    private void validateIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
