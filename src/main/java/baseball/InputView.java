package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String DIVISION = "";
    private final InputValidator validator = new InputValidator();

    public PlayerNumbers readNumbers() {
        String number = Console.readLine();
        validator.validateIsDigit(number);
        return new PlayerNumbers(Arrays.stream(number.split(DIVISION))
                .map(Integer::parseInt)
                .toList());
    }

    public RestartStatus readReplayNumber() {
        String number = Console.readLine();
        validator.validateRestartNumber(number);
        return Arrays.stream(RestartStatus.values())
                .filter(status -> status.toString().equals(number))
                .findFirst()
                .get();
    }
}