package baseball;

import java.util.ArrayList;

public class Validator {
    private static final String GO = "1";
    private static final String STOP = "2";

    public static State validateUserinputRestart(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("한 자리의 숫자만 입력해주세요.");
        }

        if (input.equals(GO)) {
            return State.START;
        } else if (input.equals(STOP)) {
            return State.END;
        } else {
            throw new IllegalArgumentException("1 또는 2의 형태로 한 자리의 숫자만 입력해주세요.");
        }
    }

    public static ArrayList<Integer> validateUserInputBalls(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }

        return validateThreeNumber(input);
    }

    private static ArrayList<Integer> validateThreeNumber(String input) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            Integer n = validateInt(input.charAt(i)); //유효한 숫자인지 확인
            numbers.add(n);
        }
        return numbers;
    }

    static int validateBallNumber(Integer number) {
        if (Ball.MIN <= number && number <= Ball.MAX) {
            return number;
        } else {
            throw new IllegalArgumentException("1~9사이의 자연수만 가능합니다.");
        }
    }

    public static int validateInt(char c) {
        int n = Character.getNumericValue(c);
        if (n == -1 || n == -2) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
        return validateBallNumber(n);
    }
}

