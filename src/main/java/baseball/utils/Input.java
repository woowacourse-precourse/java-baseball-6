package baseball.utils;

import static baseball.utils.OutputMessage.askNumberMessage;
import static baseball.utils.OutputMessage.askRestartMessage;
import static baseball.validate.CheckInput.validateUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static String askRestart() {
        askRestartMessage();
        String answer = Console.readLine();
        return answer.trim();
    }

    public static List<Integer> getPlayerInput() {
        askNumberMessage();
        return getInputString();
    }

    private static List<Integer> getInputString() {
        String userInput = Console.readLine();
        String trimInput = userInput.trim();
        validateUserInput(trimInput);
        return inputToInteger(trimInput);
    }

    //String -> Integer List로 변환
    private static List<Integer> inputToInteger(String trimInput) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answer.add(Character.getNumericValue(trimInput.charAt(i)));
        }
        return answer;
    }
}
