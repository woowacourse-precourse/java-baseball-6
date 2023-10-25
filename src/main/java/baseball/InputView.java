package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

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
        validator.validateIsDigit(number);
        return Arrays.stream(RestartStatus.values())
                .filter(status -> status.toString().equals(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.IS_NOT_RESTART_NUMBER.toString()));
    }
}