package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임 안에서 모든 입력을 담당하는 클래스이다.
 */
public class InputHandler {
    private static boolean isNumber(String inputString) {
        String isNotNumberRegex = "[^0-9]";
        if(inputString.matches(isNotNumberRegex)) {
            throw new IllegalArgumentException("Illegal Input values type.");
        }
        return true;
    }

    private static Integer parseInt(String inputString) {
        isNumber(inputString);
        return Integer.parseInt(inputString);
    }

    private static void inputLengthCheck(int expectSize, int actualSize) {
        if(expectSize != actualSize) {
            throw new IllegalArgumentException("Illegal Input values Length.");
        }
    }

    public static List<Integer> getMultipleNumbersInput(int inputSize) {
        List<Integer> inputNumbers = new ArrayList<>();

        String[] inputString = Console.readLine().split("");
        inputLengthCheck(inputSize, inputString.length);
        for(int i = 0; i < inputSize; i++) {
            inputNumbers.add(parseInt(inputString[i]));
        }
        Console.close();

        return inputNumbers;
    }

    public static Integer getOneNumberInput() {
        final int onlyOne = 1;
        String inputString = Console.readLine();
        inputLengthCheck(onlyOne, inputString.length());

        return parseInt(inputString);
    }
}
