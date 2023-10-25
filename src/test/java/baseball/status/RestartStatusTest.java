package baseball.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestartStatusTest {

    @Test
    @DisplayName("재시작 여부 입력값이 1 또는 2가 아니면 예외가 발생한다.")
    void playerNumbersTest1() {
        int input = 3;

        Assertions.assertThrows(IllegalArgumentException.class, () -> RestartStatus.getStatus(input));
    }

    @Test
    @DisplayName("재시작 여부 입력값이 1이면 재시작이다.")
    void playerNumbersTest2() {
        int input = 1;

        Assertions.assertEquals(RestartStatus.getStatus(input), RestartStatus.RESTART);
    }

    @Test
    @DisplayName("재시작 여부 입력값이 2이면 종료이다.")
    void playerNumbersTes32() {
        int input = 2;

        Assertions.assertEquals(RestartStatus.getStatus(input), RestartStatus.EXIT);
    }
}