package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class GameInput {
    private final String input;

    public GameInput() {
        String input = receiveUserInput();
        validateInputSize(input);
        validateInputDigit(input);
        validateInputDuplicated(input);
        this.input = input;
    }

    private String receiveUserInput() {
        return Console.readLine();
    }

    private void validateInputSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputDigit(String input) {
        if (!input.matches("[0-9]{3}")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputDuplicated(String input) {
        long count = input.chars()
                .distinct()
                .count();
        if (count != 3) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertInputToUserNumbers() {
        return input.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
    }
}
