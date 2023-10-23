package baseball;

import java.util.List;

public class ExceptionHandler {

    // 예외처리 1 : 세 자리 숫자가 아닌 수 입력
    public void cautionLength(String lengthTestNum) {
        if (lengthTestNum.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자만 입력가능합니다.");
        }
    }
    // 예외처리 2 : 중복된 숫자 입력
    public void cautionDuplicate(String duplicateNum_1, String duplicateNum_2, String duplicateNum_3) {
        if (duplicateNum_1.equals(duplicateNum_2) || duplicateNum_1.equals(duplicateNum_3)
                || duplicateNum_2.equals(duplicateNum_3)) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력가능합니다.");
        }
    }
    // 예외처리 3 : 숫자가 아닌 문자열 입력
    public void cautionNotNumber(String notNumber_1, String notNumber_2, String notNumber_3) {
        char a = notNumber_1.charAt(0);
        char b = notNumber_2.charAt(0);
        char c = notNumber_3.charAt(0);

        if (a < '0' || a > '9') {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
        if (b < '0' || b > '9') {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
        if (c < '0' || c > '9') {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }

}






