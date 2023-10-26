package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckUtilsTest {

    /**
     * 입력값 빈값 / 숫자타입 / 3자리 숫자 / 중복 확인 위 조건에 해당 되지 않으면 IllegalArgumentException 예외 발생
     */
    int size = 3;
    String nullStr = null;
    String emptyStr = "  ";
    String notDigit = "aaa";
    String duplicateNumStr = "112";
    String overLengthStr = "1234";
    String successStr = "123";


    @Test
    @DisplayName("입력값 빈값, 숫자타입, 3자리 숫자, 중복 확인 예외 발생")
    void inputCheck() {
        assertThrows(IllegalArgumentException.class, () -> {
            // 빈 값 시 예외 발생
            CheckUtils.userInputCheck(nullStr, size);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            // 공백 시 예외 발생
            CheckUtils.userInputCheck(emptyStr, size);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            // 숫자 타입이 아닌 경우 예외 발생
            CheckUtils.userInputCheck(notDigit, size);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            // 중복 숫자 존재 예외 발생
            CheckUtils.userInputCheck(duplicateNumStr, size);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            // size 오버 된 경우 예외 발생
            CheckUtils.userInputCheck(overLengthStr, size);
        });

        // 정상의 경우
        CheckUtils.userInputCheck(successStr, size);

    }

}