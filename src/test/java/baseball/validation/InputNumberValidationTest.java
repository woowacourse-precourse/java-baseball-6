package baseball.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberValidationTest {

    @Test
    void threeNumberValidTest() {
        assertThat(InputNumberValidation.inputThreeNumberValidate("123")).isEqualTo("123");
    }

    @Test
    void threeNumberValidFailTest() {
        //length
        assertThatThrownBy(() -> InputNumberValidation.inputThreeNumberValidate("12")).isInstanceOf(IllegalArgumentException.class);
        // formant
        assertThatThrownBy(() -> InputNumberValidation.inputThreeNumberValidate("12a")).isInstanceOf(IllegalArgumentException.class);
        // duplicate
        assertThatThrownBy(() -> InputNumberValidation.inputThreeNumberValidate("122")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void retryNumberValidTest() {
        assertThat(InputNumberValidation.inputSelectValidation("1")).isEqualTo("1");
        assertThat(InputNumberValidation.inputSelectValidation("2")).isEqualTo("2");
    }

    @Test
    void retryNumberValidFailTest() {
        // length
        assertThatThrownBy(() -> InputNumberValidation.inputSelectValidation("12")).isInstanceOf(IllegalArgumentException.class);
        // format
        assertThatThrownBy(() -> InputNumberValidation.inputSelectValidation("a")).isInstanceOf(IllegalArgumentException.class);
    }
}
