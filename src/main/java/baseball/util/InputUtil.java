package baseball.util;

import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public static String inputNumber() {
        String inputStr = Console.readLine();
        InputValidator.validateInputNumber(inputStr);

        return inputStr;
    }
}
