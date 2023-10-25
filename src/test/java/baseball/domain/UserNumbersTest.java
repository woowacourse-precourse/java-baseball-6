package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserNumbersTest {

    @Test
    @DisplayName("올바른 값을 입력하면 리스트가 반환되어야 한다.")
    void createInputNumber() {
        assertThat(UserNumbers.generate("123")).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("숫자가 아니면 예외가 발생해야 한다.")
    void validateNumber() {
        assertThatThrownBy(() -> UserNumbers.generate("sdf")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3자리가 아니면 예외가 발생해야 한다.")
    void validateNumberLength() {
        assertThatThrownBy(() -> UserNumbers.generate("1234")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 예외가 발생해야 한다.")
    void validateNumberNotDistinct() {
        assertThatThrownBy(() -> UserNumbers.generate("112")).isInstanceOf(IllegalArgumentException.class);
    }
}