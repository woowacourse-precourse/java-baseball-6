package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    public static void checkIfIsInteger(final String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력값은 정수이어야 합니다.");
        }
    }

    public static void checkIfIsValidLength(final int length, final String number) {
        if (length != number.length()) {
            throw new IllegalArgumentException("공의 개수는 " + length + "개를 입력해야 합니다.");
        }
    }

    public static void checkIfIsValidCommand(List<String> gameCommand, final String number) {
        if (!gameCommand.contains(number)) {
            throw new IllegalArgumentException("올바른 명령어가 아닙니다.");
        }
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        return input.chars()
            .filter(Character::isDigit)
            .map(Character::getNumericValue)
            .boxed()
            .collect(Collectors.toList());
    }
}



