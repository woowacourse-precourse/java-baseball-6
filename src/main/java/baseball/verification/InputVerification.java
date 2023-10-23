package baseball.verification;

public class InputVerification {
    public static void verifyNumber(String input) {
        if (input.length() != 3 || !input.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("세 자리 \"숫자\"만 허용합니다");
        }
    }
}
