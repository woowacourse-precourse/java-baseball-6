package baseball.model;

import java.util.Arrays;

public class Util {
    public static void LengthException(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }
    }

    public static void DuplicationException(String s) {
        if (Arrays.stream(s.split("")).distinct().count() != s.length()) {
            throw new IllegalArgumentException("중복되지 않는 수를 입력해주세요.");
        }
    }
}
