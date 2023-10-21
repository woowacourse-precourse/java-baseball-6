package baseball.domain;

import baseball.model.ComputerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerNumberTest {

    @Test
    @DisplayName("컴퓨터 숫자가 3자리가 아니라면 예외가 발생한다.")
    void testValidateComputerNumberSize() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴퓨터 숫자가 0을 포함하고 있으면 예외가 발생한다.")
    void testValidateComputerNumberContainZero() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(1, 2, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴퓨터 숫자 3자리 중 중복이 있으면 예외가 발생한다.")
    void testValidateComputerNumberDuplicate() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
