package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataValidatorTest {

    @DisplayName("잘못된 값이 입력될 경우 IllegalArgumentException이 발생한다.")
    @Test
    void validate() {
        DataValidator dataValidator = new DataValidator();

        String overSize = "1234";
        String duplicatedData = "112";
        String notNumber = "as";

        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> dataValidator.validateInputNumber(overSize)),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> dataValidator.validateInputNumber(duplicatedData)),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> dataValidator.validateInputNumber(notNumber))
        );
    }
}
