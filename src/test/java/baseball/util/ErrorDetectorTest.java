package baseball.util;

import static baseball.util.ErrorDetector.throwIfNumbersInputInvalid;
import static baseball.util.ErrorDetector.throwIfOptionInputInvalid;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ErrorDetectorTest {

    @Test
    void 숫자입력이_올바른_경우() {
        throwIfNumbersInputInvalid("123");
    }

    @Test
    void 옵션입력이_올바른_경우() {
        throwIfOptionInputInvalid("1");
    }

    @Test
    void 입력에영문이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> throwIfNumbersInputInvalid("11as")
        );
    }

    @Test
    void 입력에0이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> throwIfNumbersInputInvalid("120")
        );
    }

    @Test
    void 입력길이가3이아닌경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> throwIfNumbersInputInvalid("1234")
        );
    }

    @Test
    void 입력에중복이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> throwIfNumbersInputInvalid("112")
        );
    }

    @Test
    void 옵션입력에영문이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> throwIfOptionInputInvalid("av")
        );
    }

    @Test
    void 옵션입력이잘못되었을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> throwIfOptionInputInvalid("5")
        );
    }
}