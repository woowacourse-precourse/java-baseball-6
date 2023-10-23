package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String userInput;

    public String getUserInput() {
        printUserInputPrompt();
        userInput = Console.readLine();
        if (!isValidInput(userInput)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        return userInput;
    }

    private void printUserInputPrompt() {
        System.out.print("숫자를 입력해주세요 :");
    }

    private boolean isValidInput(String input) {
        return isInteger(input) && isThreeDigits(input) && isBetweenOneAndNine(input) && hasNoDuplicateNumber(input);
    }

    private boolean isInteger(String input) {   // 정수 인지 판단
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

    private boolean isThreeDigits(String input) {   // 3자리 수인지 판단
        return input.length() == 3;
    }

    private boolean isBetweenOneAndNine(String input) { // 1~9 사이의 숫자가 맞는지 판단
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("입력값은 1~9 사이의 숫자여야 합니다.");
            }
        }
        return true;
    }

    private boolean hasNoDuplicateNumber(String input) {    // 중복된 숫자가 없는지 판단
        int[] digits = new int[10];
        for (char c : input.toCharArray()) {
            if (digits[c - '0']++ > 0) {
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다.");
            }
        }
        return true;
    }

}
