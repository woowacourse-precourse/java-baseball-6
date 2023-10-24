package baseball.view.input;

import static baseball.utils.message.message.ExceptionMessage.BASEBALL_INPUT_EXCEPTION_MESSAGE;
import static baseball.utils.message.message.ExceptionMessage.END_INPUT_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInput implements Input {

    private static final String REGEX_BASEBALL = "^[1-9]{3}$";
    private static final String REGEX_END = "[12]{1}";

    @Override
    public String baseballInput() {
        String baseballInput = Console.readLine();
        validateBaseballInput(baseballInput);
        return baseballInput;
    }

    @Override
    public String endInput() {
        String endInput = Console.readLine();
        validateEndInput(endInput);
        return endInput;
    }

    private void validateBaseballInput(String baseballInput) {
        String[] baseballNumber = baseballInput.split("");
        List<String> distinctNumber = Arrays.stream(baseballNumber)
                .distinct()
                .toList();
        if (!baseballInput.matches(REGEX_BASEBALL) || distinctNumber.size() != 3) {
            throw new IllegalArgumentException(BASEBALL_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void validateEndInput(String endInput) {
        if (!endInput.matches(REGEX_END)) {
            throw new IllegalArgumentException(END_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
