package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputManager {
    ArrayList<Integer> takeUserAnswerInput() {
        String userInput;
        ArrayList<Integer> userInputNum;
        ValidateChecker validateChecker = new ValidateChecker();

        userInput = Console.readLine();
        validateChecker.isUserInputValidate(userInput);
        userInputNum = new ArrayList<>();
        for (int userInputIndex = 0; userInputIndex < 3; userInputIndex++) {
            userInputNum.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return (userInputNum);
    }

    int takeUserEndOrRetryInput() {
        int userInputNum;
        String userInput;
        ValidateChecker validateChecker = new ValidateChecker();

        userInput = Console.readLine();
        validateChecker.isRetryInputValidate(userInput);
        userInputNum = Integer.parseInt(userInput);
        return (userInputNum);
    }
}