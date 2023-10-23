package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {

    @Test
    @DisplayName("컴퓨터 숫자가 3자리가 아니라면 예외가 발생한다.")
    void testValidateComputerNumberSize() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴퓨터 숫자 3자리가 각각 범위 1~9에 속하지 않는다면 예외가 발생한다.")
    void testValidateComputerNumberRange1() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(0, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴퓨터 숫자 3자리가 각각 범위 1~9에 속하지 않는다면 예외가 발생한다.")
    void testValidateComputerNumberRange2() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(8, 9, 10)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴퓨터 숫자 3자리가 각각 범위 1~9에 속하지 않는다면 예외가 발생한다.")
    void testValidateComputerNumberRange3() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(-1, -2, -3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴퓨터 숫자 3자리 중 중복이 있으면 예외가 발생한다.")
    void testValidateComputerNumberDuplicate() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
