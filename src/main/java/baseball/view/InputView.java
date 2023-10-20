package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public List<Integer> insertNumbers() {
        String input = Console.readLine();
        validateNumber(input);
        return toIntegerList(input);
    }

    private void validateNumber(String input) {
        if (!isAllDigit(input)) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    private boolean isAllDigit(String input) {
        return input.matches("^[0-9]*$");
    }

    private List<Integer> toIntegerList(String input) {
        return input.chars()
                .map(integer -> integer - '0')
                .boxed()
                .toList();
    }

    public Command insertCommand() {
        String input = Console.readLine();
        return Command.findByString(input);
    }
}
