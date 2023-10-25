package baseball.verification;

import java.util.HashSet;
import java.util.Set;

public class InputVerification {
    public static void verifyNumber(String input) {
        if (input.length() != 3 || !input.matches("^[1-9]{3}$") || checkDuplicateNumbers(input)) {
            throw new IllegalArgumentException("중복되지 않는 1~9까지의 세 자리 \"숫자\"만 허용합니다");
        }
    }

    // 중복된 숫자가 있는지 확인
    private static boolean checkDuplicateNumbers(String input) {
        Set<Character> seenDigits = new HashSet<>();
        for (char element : input.toCharArray()) {
            if (seenDigits.contains(element)) {
                return true; // 중복된 숫자가 있으면 true 반환
            }
            seenDigits.add(element);
        }
        return false; // 중복된 숫자가 없으면 false 반환
    }
}
