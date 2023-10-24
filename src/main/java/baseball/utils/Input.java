package baseball.utils;

import static baseball.utils.OutputMessage.askNumberMessage;
import static baseball.utils.OutputMessage.askRestartMessage;
import static baseball.validate.CheckInput.validatePlayerInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final int INPUT_LENGTH = 3;

    public static String askRestart() {
        askRestartMessage();
        String answer = Console.readLine();
        return answer.trim();
    }

    public static List<Integer> askPlayerInput() {
        askNumberMessage();
        String stringInput = getInputString();
        return stringToInteger(stringInput);
    }

    private static String getInputString() {
        String playerInput = Console.readLine();
        String trimInput = playerInput.trim();
        validatePlayerInput(trimInput);
        return trimInput;
    }

    private static List<Integer> stringToInteger(String trimInput) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < INPUT_LENGTH; i++) {
            answer.add(Character.getNumericValue(trimInput.charAt(i)));
        }
        return answer;
    }
}
