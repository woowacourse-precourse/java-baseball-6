package baseball.game;

public class Validator {
    public static void validRestartNum(int num) {
        if (num != 1 && num != 2) throw new IllegalArgumentException("잘못된 입력");
    }

    public static void validDigit(int num) throws IllegalArgumentException {
        if (num > 999 || num < 100) throw new IllegalArgumentException("잘못된 입력");
    }

    public static void validIsInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
            return;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }
}
