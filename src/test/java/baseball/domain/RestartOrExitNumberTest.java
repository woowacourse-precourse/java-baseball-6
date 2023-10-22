package baseball.domain;

import baseball.model.RestartOrExitNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestartOrExitNumberTest {

    @Test
    @DisplayName("게임을 새로 시작 혹은 완전한 종료를 나타내는 숫자가 1 혹은 2가 아니라면 예외가 발생한다.")
    void testValidateRestartOrExitNumber1() {
        int restartOrExitNumber = 0;

        Assertions.assertThatThrownBy(() -> new RestartOrExitNumber(restartOrExitNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임을 새로 시작 혹은 완전한 종료를 나타내는 숫자가 1 혹은 2가 아니라면 예외가 발생한다.")
    void testValidateRestartOrExitNumber2() {
        int restartOrExitNumber = 3;

        Assertions.assertThatThrownBy(() -> new RestartOrExitNumber(restartOrExitNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
