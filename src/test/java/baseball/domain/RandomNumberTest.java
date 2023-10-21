package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    @DisplayName("랜덤한 숫자를 생성할 수 있다")
    void generateTest() {
        assertDoesNotThrow(RandomNumber::generate);
    }
}
