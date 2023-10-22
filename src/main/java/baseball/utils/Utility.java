package baseball.utils;

import baseball.domain.Response;
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

    public static String convertResponseToResult(Response response) {
        int strikes = response.getStrikeCount();
        int balls = response.getBallCount();

        if (strikes == 0 && balls == 0) {
            return "낫싱\n";
        } else if (strikes > 0 && balls == 0) {
            return strikes + "스트라이크\n";
        } else if (strikes == 0 && balls > 0) {
            return balls + "볼\n";
        } else {
            return balls + "볼 " + strikes + "스트라이크\n";
        }
    }
}



