package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void checkInput(String inputString, int length) {
        // 검증할 내용
        // 1. 길이가 length와 같은가
        // 2. 숫자 이외의 다른 문자가 포함되어 있는가
        // 3. 숫자가 중복으로 들어왔는가
        if (!(isLengthEquals(inputString, length) || isContainElseNumber(inputString) || isContainDuplicatedNum(inputString))) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public static void isValidRestartNumber(String str) {
        int c = str.charAt(0) - '0';
        if (c != 1 && c != 2) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    private static boolean isLengthEquals(String str, int len) {
        return str.length() == len;
    }

    private static boolean isContainElseNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9 ) {
                return false;
            }
        }
        return true;
    }

    private static boolean isContainDuplicatedNum(String str) {
        Set<Integer> container = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (container.contains(str.charAt(i) - '0')) {
                return false;
            }
            container.add(str.charAt(i) - '0');
        }
        return true;
    }
}
