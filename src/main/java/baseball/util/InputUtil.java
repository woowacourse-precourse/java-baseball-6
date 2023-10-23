package baseball.util;

import static baseball.constant.Constant.CLOSE;

import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public static String inputNumber() {
        String inputStr = Console.readLine();
        InputValidator.validateInputNumber(inputStr);

        return inputStr;
    }

    public static boolean inputRestartOrClose(){
        String inputStr = Console.readLine();
        InputValidator.validateRestartOrClose(inputStr);

        int input = Integer.parseInt(inputStr);

        return !inputStr.equals(CLOSE);
    }
}
