package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static final int INPUT_NUMBER_SIZE = 3;
    public static final int GAME_RESTART_NUMBER = 1;
    public static final String REGEX = "";

    private List<Integer> inputNumber = new ArrayList<>();

    public List<Integer> inputNumber() {
        inputNumber = integerNumber(List.of(Console.readLine().split(REGEX)));
        validationNotSize();

        return inputNumber;
    }

    private void validationNotSize() {
        duplicateValidationNumber();

        if (inputNumber.size() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateValidationNumber() {
        Set<Integer> setNumber = new HashSet<>(inputNumber);

        if (setNumber.size() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> integerNumber(List<String> stringNumber) {
        return stringNumber.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public boolean restartCheck() {
        return Integer.parseInt(Console.readLine()) == GAME_RESTART_NUMBER;
    }
}
