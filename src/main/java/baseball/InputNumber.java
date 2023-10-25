package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    public static int[] getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        validateInputLength(inputStr);
        validateInputIsNumeric(inputStr);
        int[] input = parseInput(inputStr);
        validateInputIsUnique(input);
        return input;
    }

    private static void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    private static void validateInputIsNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    private static int[] parseInput(String input) {
        int[] parsedInput = new int[3];
        for (int i = 0; i < 3; i++) {
            parsedInput[i] = Character.getNumericValue(input.charAt(i));
        }
        return parsedInput;
    }

    private static void validateInputIsUnique(int[] input) {
        if (input[0] == input[1] || input[1] == input[2] || input[0] == input[2]) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }
}