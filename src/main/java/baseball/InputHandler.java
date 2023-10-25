package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임 안에서 모든 입력을 담당하는 클래스이다.
 */
public class InputHandler {
    public static List<Integer> getMultipleNumbersInput(int inputSize) {
        List<Integer> inputNumbers = new ArrayList<>();

        String inputString = getConsoleInput();
        String[] splitInput = inputString.split("");

        inputLengthCheck(inputSize, splitInput.length);
        for(int i = 0; i < inputSize; i++) {
            inputNumbers.add(parseInt(splitInput[i]));
        }

        return inputNumbers;
    }

    private static String getConsoleInput() {
        String inputValue = Console.readLine();

        return inputValue;
    }

    private static void inputLengthCheck(int expectSize, int actualSize) {
        if(expectSize != actualSize) {
            throw new IllegalArgumentException("Illegal Input values Length. except length : " + expectSize + ", actual length : " + actualSize);
        }
    }

    private static Integer parseInt(String inputString) {
        isNumber(inputString);
        return Integer.parseInt(inputString);
    }

    private static boolean isNumber(String inputString) {
        String isNotNumberRegex = "[^0-9]";
        if(inputString.matches(isNotNumberRegex)) {
            throw new IllegalArgumentException("Illegal Input values type. input string : " + inputString);
        }
        return true;
    }

    public static Integer getOneNumberInput() {
        final int oneInput = 1;
        String inputString = getConsoleInput();
        inputLengthCheck(oneInput, inputString.length());

        return parseInt(inputString);
    }
}
