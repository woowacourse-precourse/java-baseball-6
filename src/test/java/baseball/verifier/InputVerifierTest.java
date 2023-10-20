package baseball.verifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputVerifierTest {
    @DisplayName("숫자값이 입력되지 않았을 때 예외 처리하는지 테스트")
    @Test
    void throwNumricException(){
        InputVerifier inputVerifier = new InputVerifier();
        assertThrows(IllegalArgumentException.class,() -> inputVerifier.checkBallNumber("숫자아님"));
    }
}
