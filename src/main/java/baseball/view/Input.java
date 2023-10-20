package baseball.view;

import baseball.util.NumberValidation;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String UserInputNumber() {
        String UserInput = Console.readLine();
        NumberValidation.InputValidate(UserInput);
        return UserInput;
    }

}
