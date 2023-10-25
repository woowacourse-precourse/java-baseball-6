package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    static String THREE_DIGIT_INPUT_ERROR_MESSAGE = "3자리 숫자를 입력하셔야 합니다.";
    static String RE_START_INPUT_ERROR_MESSAGE = "1 또는 2를 입력하셔야 합니다.";

    public static List<Integer> getThreeDigits() {
        OutputView.printInputThreeDigits();
        String userInput = Console.readLine();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(THREE_DIGIT_INPUT_ERROR_MESSAGE);
        }
        List<Integer> threeDigits = new ArrayList<>();
        for (int i = 0; i < userInput.length(); ++i) {
            char digit = userInput.charAt(i);
            if (Character.isDigit(digit)) {
                threeDigits.add(digit - '0');
            } else {
                throw new IllegalArgumentException(THREE_DIGIT_INPUT_ERROR_MESSAGE);
            }
        }
        return threeDigits;
    }

    public static int getRestartInput() {
        OutputView.printRestartInputMessage();
        String reStartInput = Console.readLine();
        if (reStartInput.length() != 1) {
            throw new IllegalArgumentException(RE_START_INPUT_ERROR_MESSAGE);
        }
        if (!Character.isDigit(reStartInput.charAt(0))) {
            throw new IllegalArgumentException(RE_START_INPUT_ERROR_MESSAGE);
        }
        if (!reStartInput.equals("1") && !reStartInput.equals("2")) {
            throw new IllegalArgumentException(RE_START_INPUT_ERROR_MESSAGE);
        }
        return Integer.parseInt(reStartInput);
    }
}
