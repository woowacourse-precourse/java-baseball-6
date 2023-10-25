package baseball.view;

import baseball.domain.PlayerNumbers;
import baseball.status.RestartStatus;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView {
    private final InputValidator validator = new InputValidator();

    public PlayerNumbers readNumbers() {
        String number = Console.readLine();
        validator.validateIsDigit(number);
        return new PlayerNumbers(Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .toList());
    }

    public RestartStatus readReplayNumber() {
        String number = Console.readLine();
        validator.validateIsDigit(number);
        return RestartStatus.getStatus(Integer.parseInt(number));
    }
}