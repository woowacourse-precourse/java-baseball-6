package baseball;

public class Validator {

    public static void isValidateRestartInput(String response) {
        isEmpty(response);
        isDigit(response);
        isValidDigit(response);
    }

    public static void isValidatePlayerNumberInput(String playerNumber) {
        isEmpty(playerNumber);
        isDigit(playerNumber);
        isThreeDigit(playerNumber);
        isValidRange(playerNumber);
        isDuplicated(playerNumber);
    }

    private static void isEmpty(String num) {
    if (num.isEmpty()) {
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }
    }

    private static void isDigit(String num) {
        if (!num.chars().allMatch(Character::isDigit)) {
            System.out.println(123);
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static void isThreeDigit(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException("3자리의 수가 아닙니다.");
        }
    }

    private static void isValidRange(String num) {
        if (!num.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("1부터 9까지의 수가 아닙니다.");
        }
    }

    private static void isDuplicated(String num) {
        if (num.chars().distinct().count() != num.length()) {
            throw new IllegalArgumentException("서로 다른 수가 아닙니다.");
        }
    }

    private static void isValidDigit(String num) {
        if (!(num.equals("1") || num.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2의 수가 아닙니다.");
        }
    }
}
