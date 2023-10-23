package baseball.domain;

import java.util.Arrays;

public class UserBalls {
    private final String balls;

    public UserBalls(String balls) {
        validateBalls(balls);
        this.balls = balls;
    }

    public static void validateBalls(String input) {
        if (!is3Length(input) || isNan(input) || isLessThan1(input) || isDuplicate(input)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다. 1~9사이의 중복되지 않는 3자리의 숫자를 입력해주세요.");
        }
    }

    public static boolean is3Length(String data) {
        return data.length() == 3;
    }

    public static boolean isNan(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    public static boolean isLessThan1(String data) {
        String[] splitedData = data.split("");
        return Arrays.stream(splitedData).map(Integer::parseInt).anyMatch((number) -> number < 1);
    }

    public static boolean isDuplicate(String data) {
        long count = data.chars().distinct().count();
        return count != 3;
    }
}
