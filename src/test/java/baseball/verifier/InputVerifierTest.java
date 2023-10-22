package baseball.verifier;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputVerifierTest {
    @DisplayName("숫자값이 입력되지 않았을 때 예외처리 하는지 테스트")
    @Test
    void throwNumricException() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.checkBallNumber("숫자아님"));
    }

    @DisplayName("입력값이 123 ~ 987 사이의 수가 아닐 때 예외처리 하는지 테스트")
    @Test
    void throwRangeException() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.checkBallNumber("1000"));
    }

    @DisplayName("중복값이 있을 때 예외처리 하는지 테스트")
    @Test
    void throwNotDistinct() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.checkBallNumber("155"));
    }

    @DisplayName("1, 2 이외의 값을 받았을 때 예외처리 하는지 테스트")
    @Test
    void throwNotGameNumber() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.checkGameNumber("456"));
    }

    @DisplayName("0이 포함되었을 때 예외처리 하는지 테스트")
    @Test
    void ifIncludeZero() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.checkBallNumber("507"));
    }
}
