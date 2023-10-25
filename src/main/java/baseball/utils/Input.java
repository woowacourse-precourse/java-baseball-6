package baseball.utils;


import baseball.validate.CheckInput;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final int INPUT_LENGTH = 3;

    public static String askRestart() {
        OutputMessage.askRestartMessage();
        String answer = Console.readLine();
        return answer.trim();
    }

    public static List<Integer> askPlayerInput() {
        OutputMessage.askNumberMessage();
        String stringInput = getInputString();
        return stringToInteger(stringInput);
    }

    private static String getInputString() {
        String playerInput = Console.readLine();
        String trimInput = playerInput.trim();
        CheckInput.validatePlayerInput(trimInput);
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
