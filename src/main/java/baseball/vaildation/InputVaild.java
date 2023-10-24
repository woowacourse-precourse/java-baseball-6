package baseball.vaildation;

import baseball.model.Game;

public class InputVaild {

    public static String inputVaildation(String input) {
        isInt(input);
        isContainZero(input);
        isLength3(input);
        return input;
    }

    private static void isContainZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private static void isLength3(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private static void isInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
