package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @DisplayName("세 자리 수 인지 확인")
    @Test
    void checkArrayLength() {
        String userNumbers = "1234";

        assertThatThrownBy(() -> {
            Validator.checkArrayLength(userNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1~9 숫자인지 확인")
    @Test
    void checkRange() {
        String userNumbers = "102";

        assertThatThrownBy(() -> {
            Validator.checkRange(userNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("숫자인지 확인")
    @Test
    void checkArrayNumber() {
        String userNumbers = "ㅇㅇ";

        assertThatThrownBy(() -> {
            Validator.checkArrayNumber(userNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("중복된 숫자 있는지 확인")
    @Test
    void checkDuplicateNumber() {
        String userNumbers = "131";

        assertThatThrownBy(() -> {
            Validator.checkForDuplicateNumbers(userNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1 또는 2인지 확인")
    @Test
    void checkNumber1or2() {
        String userInput = "3";

        assertThatThrownBy(() -> {
            Validator.checkOneOrTwo(userInput);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
