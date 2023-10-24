package baseball.view;

import baseball.constant.RetryCommand;
import baseball.domain.Numbers;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public Numbers readPlayerBall() {
        String input = Console.readLine();
        inputValidator.validateIsNumber(input);
        return new Numbers(Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList());
    }

    public RetryCommand readRetry() {
        String input = Console.readLine();
        inputValidator.validateIsNumber(input);
        return RetryCommand.getRetryCommand(Integer.parseInt(input));
    }
}