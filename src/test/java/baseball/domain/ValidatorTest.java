package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 세_자리수_인지_확인() {
        String userNumbers = "1234";

        assertThatThrownBy(() -> {
            Validator.checkArrayLength(userNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
