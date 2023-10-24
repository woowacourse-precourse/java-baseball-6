package baseball.io;

import baseball.io.validator.BaseballInputValidator;
import baseball.io.validator.ProcessDecisionCommandValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    private static final BaseballInputValidator BASEBALL_INPUT_VALIDATOR = new BaseballInputValidator();
    private static final ProcessDecisionCommandValidator PROCESS_DECISION_COMMAND_VALIDATOR
            = new ProcessDecisionCommandValidator();

    private InputProcessor() {
    }

    public static List<Integer> readUserBaseballs() {
        System.out.print("숫자를 입력해주세요 : ");

        final String userInput = Console.readLine();
        BASEBALL_INPUT_VALIDATOR.validate(userInput);

        return convertStringToList(userInput);
    }

    private static List<Integer> convertStringToList(final String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public static int readUserRestartCommand() {
        final String userInput = Console.readLine();
        PROCESS_DECISION_COMMAND_VALIDATOR.validate(userInput);

        return Integer.parseInt(userInput);
    }
}
