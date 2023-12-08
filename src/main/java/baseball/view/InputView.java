package baseball.view;

import baseball.exception.ErrorMessages;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<Integer> enterUserNumbers() {
        System.out.print(BaseballMessages.INPUT_NUMBERS_MESSAGE);
        String input = Console.readLine()
                .trim();
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_FORMAT_ERROR);
        }
    }

    public int enterRestartOrEnd() {
        System.out.println(BaseballMessages.CONTINUE_OR_END_MESSAGE);
        String input = Console.readLine()
                .trim();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_FORMAT_ERROR);
        }
    }
}
