package baseball.util;

public class Validation {
    public static void isValidInputNumber(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException("세개의 숫자만 입력하세요.");

        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0')
                throw new IllegalArgumentException("1~9사이의 내용만 입력해야 합니다,");
        }

        if ((input.charAt(0) == input.charAt(1))
                || input.charAt(1) == input.charAt(2)
                || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 숫자 세자리를 입력하세요.");
        }
    }

    public static String isValidGameFlag(String gameFlag) {
        if (!gameFlag.equals("1") && !gameFlag.equals("2"))
            throw new IllegalArgumentException("1또는 2의 값만 입력 가능합니다.");
        return gameFlag;
    }
}
