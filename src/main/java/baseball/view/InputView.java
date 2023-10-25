package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {

    public int[] inputThreeDigitNumber() {
        String input = Console.readLine();
        validateOnlyNumbers(input);
        validateThreeDigitNumber(input);
        validateNonDuplicateDigits(input);

        return convertToNumbers(input);
    }

    public int inputRestartOrExit() {
        String input = Console.readLine();
        validateOnlyNumbers(input);
        int inputNumbers = convertToNumber(input);
        validateRestartOrExitNumber(inputNumbers);

        return inputNumbers;
    }

    private int[] convertToNumbers(String input) {
        int[] playersNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            playersNumbers[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return playersNumbers;
    }

    private int convertToNumber(String input) {
        return Integer.parseInt(input);
    }

    private void validateThreeDigitNumber(String input) {
        int threeDigit = 3;
        if (input.length() != threeDigit) {
            throw new IllegalArgumentException("세 자리의 숫자를 입력해 주세요.");
        }
    }

    private void validateRestartOrExitNumber(int inputNumbers) {
        final int restartNumber = 1;
        final int exitNumber = 2;
        if (restartNumber != inputNumbers && exitNumber != inputNumbers) {
            throw new IllegalArgumentException(GameInstructions.ASK_RESTART_OR_EXIT.getMessage());
        }
    }

    private void validateOnlyNumbers(String input) {
        String numberRange = "^[1-9]+$";
        if (!Pattern.matches(numberRange, input)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private void validateNonDuplicateDigits(String input) {
        char firstDigit = input.charAt(0);
        char secondDigit = input.charAt(1);
        char thirdDigit = input.charAt(2);

        if (firstDigit == secondDigit || secondDigit == thirdDigit || firstDigit == thirdDigit) {
            throw new IllegalArgumentException("중복되지 않는 세 자리의 숫자를 입력해 주세요.");
        }
    }
}
