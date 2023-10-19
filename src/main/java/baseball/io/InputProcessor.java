package baseball.io;

import baseball.io.validator.BaseballInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    private static final BaseballInputValidator BASEBALL_INPUT_VALIDATOR = new BaseballInputValidator();

    public static List<Integer> readUserBaseballs() {
        System.out.print("숫자를 입력해주세요 : ");

        final String userInput = Console.readLine();
        BASEBALL_INPUT_VALIDATOR.validateInputHasSpace(userInput);

        return convertBaseballs(userInput);
    }

    private static List<Integer> convertBaseballs(final String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
