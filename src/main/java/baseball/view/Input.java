package baseball.view;

import baseball.util.NumberValidation;
import baseball.util.RestartValidation;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String UserInputNumber() {
        String UserInput = Console.readLine();
        NumberValidation.InputValidate(UserInput);
        return UserInput;
    }

    public static String UserInputRestart() {
        String UserInput = Console.readLine();
        RestartValidation.RestartValidate(UserInput);
        return UserInput;
    }

}
