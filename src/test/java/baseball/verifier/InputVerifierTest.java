package baseball.verifier;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputVerifierTest {
    @DisplayName("숫자값이 입력되지 않았을 때 예외처리 하는지 테스트")
    @Test
    void throwNumricException() {
        InputVerifier inputVerifier = new InputVerifier();
        assertThrows(IllegalArgumentException.class, () -> inputVerifier.checkBallNumber("숫자아님"));
    }

    @DisplayName("입력값이 123 ~ 987 사이의 수가 아닐 때 예외처리 하는지 테스트")
    @Test
    void throwRangeException() {
        InputVerifier inputVerifier = new InputVerifier();
        assertThrows(IllegalArgumentException.class, () -> inputVerifier.checkBallNumber("1000"));
    }

    @DisplayName("중복값이 있을 때 예외처리 하는지 테스트")
    @Test
    void throwNotDistinct() {
        InputVerifier inputVerifier = new InputVerifier();
        assertThrows(IllegalArgumentException.class, () -> inputVerifier.checkBallNumber("155"));
    }
}
