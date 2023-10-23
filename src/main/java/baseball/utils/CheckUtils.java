package baseball.utils;

import java.util.Arrays;

public class CheckUtils {

    /**
     * 입력값 빈값 / 숫자타입 / 3자리 숫자 / 중복 확인 위 조건에 해당 되지 않으면 IllegalArgumentException 예외 발생
     */
    public static void userInputCheck(String s, int size) {
        // 입력값 빈값 확인
        nullOrEmptyCheck(s);

        // 숫자 타입 확인
        isDigit(s);

        // 사이즈 확인
        lengthSizeCheck(s, size);

        // 중복 값 확인
        checkDuplicateValues(s, size);
    }

    /**
     * 중복 값 확인
     */
    private static void checkDuplicateValues(String s, int size) {
        String[] split = s.split("");
        if (Arrays.stream(split).distinct().count() != size) {
            throw new IllegalArgumentException("중복된 숫자가 존재 합니다.");
        }
    }

    /**
     * 자릿수 확인
     */
    private static void lengthSizeCheck(String s, int size) {
        if (s.length() != size) {
            throw new IllegalArgumentException(size + "자리 숫자가 아닙니다.");
        }
    }

    /**
     * 숫자 타입 확인
     */
    private static void isDigit(String s) {
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("잘못 된 값이 입력 되었습니다. : " + String.valueOf(c));
            }
        }
    }


    /**
     * 입력값 빈값 확인
     */
    private static void nullOrEmptyCheck(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            throw new IllegalArgumentException("입력 값이 빈 값 입니다.");
        }
    }
}
