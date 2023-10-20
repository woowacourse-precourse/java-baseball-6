package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ErrorDetectorTest {

    @Test
    void 숫자입력이_올바른_경우() {
        ErrorDetector.throwIfNumbersInputInvalid("123");
    }

    @Test
    void 옵션입력이_올바른_경우() {
        ErrorDetector.throwIfOptionInputInvalid("1");
    }

    @Test
    void 입력에영문이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfNumbersInputInvalid("11as")
        );
    }

    @Test
    void 입력길이가3이아닌경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfNumbersInputInvalid("1234")
        );
    }

    @Test
    void 옵션입력에영문이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfOptionInputInvalid("av")
        );
    }

    @Test
    void 옵션입력이잘못되었을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.throwIfOptionInputInvalid("5")
        );
    }
}