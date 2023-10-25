package baseball.utils;

import baseball.model.ball.Ball;
import baseball.model.ball.Balls;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Utility {

    public static void checkIfIsPositiveDigitInteger(final String number) {
        if (!number.matches("[1-9]+")) {
            throw new IllegalArgumentException("입력 값은 양의 일의자리 정수이어야 합니다.");
        }
    }

    public static void checkIfIsDifferent(final String numbers) {
        Set<Character> digitSet = new HashSet<>();

        for (char number : numbers.toCharArray()) {
            if (!digitSet.add(number)) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
            }
        }
    }

    public static void checkIfIsValidLength(final int length, final String number) {
        if (length != number.length()) {
            throw new IllegalArgumentException("공의 개수는 " + length + "개를 입력해야 합니다.");
        }
    }

    public static Balls convertStringToBalls(String input, int length) {
        validateInput(input, length);

        List<Ball> ballList = input.chars()
            .filter(Character::isDigit)
            .mapToObj(ch -> new Ball(Character.getNumericValue(ch)))
            .collect(Collectors.toList());

        return new Balls(ballList);
    }

    private static void validateInput(String input, int length) {
        Utility.checkIfIsPositiveDigitInteger(input);
        Utility.checkIfIsDifferent(input);
        Utility.checkIfIsValidLength(length, input);
    }
}
