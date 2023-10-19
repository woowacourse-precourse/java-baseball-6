package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorDetectorTest {

    @Test
    void 입력에영문이있을경우() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfNumbersInputInvalid("11as")
        );
    }

    @Test
    void 입력길이가3이아닌경우() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfNumbersInputInvalid("1234")
        );
    }

    @Test
    void 옵션입력에영문이있을경우() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfOptionInputInvalid("av")
        );
    }
    @Test
    void 옵션입력이잘못되었을경우() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfOptionInputInvalid("5")
        );
    }
}