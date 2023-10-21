package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String ELEMENT = "";
    private final InputValidator validator = new InputValidator();

    public List<Integer> readNumbers() {
        String number = Console.readLine();
        validator.validateNumber(number);
        return Arrays.stream(number.split(ELEMENT))
                .map(Integer::parseInt)
                .toList();
    }

    public boolean readReplayNumber() {
        String number = Console.readLine();
        return number.equals(RestartStatus.RESTART.toString());
    }
}