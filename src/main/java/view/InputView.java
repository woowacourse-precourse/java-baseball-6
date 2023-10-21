package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    static String THREE_DIGIT_INPUT_ERROR_MESSAGE = "3자리 숫자를 입력하셔야 합니다.";

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
}
